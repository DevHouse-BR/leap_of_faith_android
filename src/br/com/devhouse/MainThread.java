package br.com.devhouse;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

public class MainThread extends Thread {
	
	private static final String TAG = MainThread.class.getSimpleName();
	
	private boolean running;
	private SurfaceHolder surfaceHolder;
	private MainGamePanel gamePanel;
	
	public MainThread(SurfaceHolder surfaceHolder, MainGamePanel gamePanel){
		super();
		this.surfaceHolder = surfaceHolder;
		this.gamePanel = gamePanel;
	}
	
	public void setRunning(boolean running){
		this.running = running;
	}
	
	@Override
	public void run(){
		Canvas canvas;
		
		Log.d(TAG, "Iniciando o Loop do Jogo");
		
		while(running){
			canvas = null;
			
			//Tentativa de travar o canvas para edicao exclusiva de pixels na Surface
			try{
				canvas = this.surfaceHolder.lockCanvas();
				synchronized (surfaceHolder) {
					//Atualiza o estado do jogo
					this.gamePanel.update();
					
					//desenha o canvas no painel
					this.gamePanel.render(canvas);
				}
			}
			finally{
				//No caso de uma excessão a Surface nao eh deixada em um estado de inconsistencia
				if(canvas != null){
					surfaceHolder.unlockCanvasAndPost(canvas);
				}
			}			
		}
	}
}
