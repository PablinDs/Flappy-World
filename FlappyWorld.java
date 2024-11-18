import java.util.Set;
import java.util.ArrayList;
import java.util.Random;

public class FlappyWorld implements Jogo{
	
	public Mundo bird;
	public Random gerador = new Random();
	public int record = 0;
	public ScoreNumber scorenumber;
	
	public int game_state = 0;
	
	public double scenario_offset = 0;
	public double ground_offset = 0;
	public ArrayList<Lixeira> lixeiras = new ArrayList<Lixeira>();
	public Timer pipetimer;
	public Hitbox groundbox;
	
	public Timer auxtimer;
	
	
	private Acao addCano(){
		return new Acao(){
			public void executa(){
				lixeiras.add(new Lixeira(getLargura(),gerador.nextInt(getAltura()-112-Lixeira.HOLESIZE)));
			}
		};
	}
	
	private Acao proxCena(){
		return new Acao(){
			public void executa(){
				game_state += 1;
				game_state = game_state%4;
			}
		};
	}
	
	
	
	public FlappyWorld(){
		bird = new Mundo(50,getAltura()/4);
		pipetimer = new Timer(2,true,addCano());
		scorenumber = new ScoreNumber(0);
		groundbox = new Hitbox(0, getAltura()-112, getLargura(), getAltura());
		
		
	}

	public String getTitulo(){
		return "Flappy World";
	}
	public String getAuthor(){
		return "APS";
	}
	public int getLargura(){
		return 384;
	}
	public int getAltura(){
		return 512;
	}
	
	public void gameOver(){
		lixeiras = new ArrayList<Lixeira>();
		bird = new Mundo(50,getAltura()/4);
		proxCena().executa();
	}
	
	public void tique(Set<String> keys, double dt){
		scenario_offset += dt*25;
		scenario_offset = scenario_offset % 288;
		ground_offset += dt*100;
		ground_offset = ground_offset%308;
		
		switch(game_state){
		case 0: //tela principal
			break;
		case 1: //tela preparado
			auxtimer.tique(dt);
			bird.updateSprite(dt);
			break;
		case 2: //Tela do jogo
			pipetimer.tique(dt);
			bird.update(dt);
			bird.updateSprite(dt);
			if(groundbox.intersecao(bird.box)!=0){
				gameOver();
				return;
			}
			if(bird.y<-5){
				gameOver();
				return;
			}
			for(Lixeira lixeira: lixeiras){
				lixeira.tique(dt);
				if(lixeira.boxcima.intersecao(bird.box)!=0 || lixeira.boxbaixo.intersecao(bird.box)!=0){
					if(scorenumber.getScore()>ScoreNumber.record){
						ScoreNumber.record = scorenumber.getScore();
					}
					gameOver();
					return;
				}
				if(!lixeira.counted && lixeira.x < bird.x){
					lixeira.counted = true;
					scorenumber.modifyScore(1);;
				}
			}
			if(lixeiras.size() > 0 && lixeiras.get(0).x < -70){
				lixeiras.remove(0);
			}
			
			break;
		case 3: //tela poluiu a terra
			break;
		}
	}
	public void tecla(String c){
		switch(game_state){
		case 0:
			if(c.equals(" ")){
				auxtimer = new Timer(1.6, false, proxCena());
				proxCena().executa();
			}
			break;
		case 1:
			break;
		case 2:
			if(c.equals(" ")){
				bird.flap();
			}
			break;
		case 3:
			if(c.equals(" ")){
				scorenumber.setScore(0);
				proxCena().executa();
			}
			break;
		}
	}

	public void desenhar(Tela t){
		t.imagem("flappy.png", 0, 0, 288, 512, 0,(int) -scenario_offset, 0);
		t.imagem("flappy.png", 0, 0, 288, 512, 0, (int) (288 - scenario_offset), 0);
		t.imagem("flappy.png", 0, 0, 288, 512, 0, (int) ((288*2) - scenario_offset), 0);
		
		for(Lixeira lixeira: lixeiras){
			lixeira.drawItself(t);
		}
		
	
		t.imagem("flappy.png", 292, 0, 308, 112, 0, -ground_offset, getAltura()-112);
		t.imagem("flappy.png", 292, 0, 308, 112, 0, 308 -ground_offset, getAltura()-112);
		t.imagem("flappy.png", 292, 0, 308, 112, 0, (308*2) - ground_offset, getAltura()-112);
		
		switch(game_state){
		case 0:
			t.imagem("flappy.png", 292, 346, 192, 44, 0, getLargura()/2 - 192/2, 100);
			t.imagem("flappy.png", 352, 306, 70, 36, 0, getLargura()/2 - 70/2, 175);
			t.texto("Pressione espaço", 60, getAltura()/2 - 16, 32, Cor.PRETO);
			break;
		case 1:
			bird.drawItself(t);
			t.imagem("flappy.png",292,442,174,44, 0, getLargura()/2 - 174/2, getAltura()/3);
			scorenumber.drawScore(t, 5, 5);
			break;
		case 2:
			scorenumber.drawScore(t, 5, 5);
			bird.drawItself(t);
			break;
		case 3:
			t.imagem("flappy.png", 292, 398, 188, 38, 0, getLargura()/2 - 188/2, 100);
			t.imagem("flappy.png", 292, 116, 226, 116, 0, getLargura()/2 - 226/2, getAltura()/2 - 116/2);
			scorenumber.drawScore(t, getLargura()/2 + 50, getAltura()/2-25);
			scorenumber.drawRecord(t, getLargura()/2 + 55, getAltura()/2 + 16);
			break;
		}		
	}
	public static void main(String[] args) {
        roda();
    }
    
    private static void roda() {
    	new Motor(new FlappyWorld());
    }
	
}
