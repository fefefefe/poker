package gui;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class StartScreen {
	//HOW TO: Center point of Screen
	//System.out.println(ge.getCenterPoint());
	
	public String[] playerNames;
	public int buyIn;
	public int nrOfHumanPlayers;
	
	/**
	 * @TODO: variable version needs to be replaced if a global version variable was created  
	 */
	private static final float version=(float) 0.1;
	private static final Dimension windowDefaultDimension = new Dimension(820,450);
	
	private JFrame startFrame =  new JFrame("Poker Game - v"+version);
	private static final Color tableColor = new Color(28,121,15);  
	
	
	public StartScreen() {
		/* NOT USED:   ##anyway might be useful: 
		//HOW TO get the screen resolution :
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice defDev = ge.getDefaultScreenDevice();
		DisplayMode dm = defDev.getDisplayMode();
		System.out.println("Auflösung:"+dm.getWidth()+"x"+dm.getHeight());
		*/
	
		initStartFrame();
		initStaticElements();
		initVariableElements();
		initLicense();
		
		//Only enable pack() is LayoutManager is enabled!
		//propSelection.pack();

		//Show all components on start screen
		startFrame.setVisible(true);
		
		
	}
	private void initLicense() {
		// TODO Auto-generated method stub
		JLabel frontImageLicense = new JLabel("GoSco");
	    
	    frontImageLicense.setFont( new Font("Serif", Font.PLAIN, 8) );
	    frontImageLicense.setForeground( Color.BLACK );
	    frontImageLicense.setBounds(40, 360, 160, 15);
	    frontImageLicense.setToolTipText("www.iconspedia.com/icon/poker-420-.html");
	    
	    MouseListener ml = new MouseListener() {						
			@Override
	    	public void mouseReleased(MouseEvent e) {
			}			
			@Override
			public void mousePressed(MouseEvent e) {							
			}			
			@Override
			public void mouseExited(MouseEvent e) {
			}			
			@Override
			public void mouseEntered(MouseEvent e) {								
			}			
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
				  Desktop.getDesktop().browse( new URI("www.iconspedia.com/icon/poker-420-.html") );				  
				}
				catch ( URISyntaxException e0 )
				{
				  e0.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
			}
		};
		frontImageLicense.addMouseListener(ml);
	    startFrame.add(frontImageLicense);
	}

	private void initStaticElements(){
		
		JLabel heading = new JLabel( "Poker Game - v"+version);
	    JLabel selHPlayers = new JLabel("Please select nr. of Human Players:");
	    JLabel selBuyIn = new JLabel("Please select buy in value:");
	    
	    
	    JLabel frontImage = new JLabel(new ImageIcon("res/chipsDeck.png"));
	    
	    
	    frontImage.setBounds(30, 170, 259, 259);	    
	    
	    selHPlayers.setFont( new Font("Serif", Font.PLAIN, 14) );
	    selHPlayers.setForeground( Color.BLACK );
	    selHPlayers.setBounds(50, 80, 270, 15);
	    
	    selBuyIn.setFont( new Font("Serif", Font.PLAIN, 14) );
	    selBuyIn.setForeground( Color.BLACK );
	    selBuyIn.setBounds(50, 100, 270, 15);
	    
		heading.setFont( new Font("Serif", Font.BOLD, 20) );
	    heading.setForeground( Color.BLACK );
	    heading.setBounds(300, 10, 240, 30);
		
	    startFrame.add(frontImage);	    
	    startFrame.add(selBuyIn);	    
	    startFrame.add(selHPlayers);
	    startFrame.add(heading);
		
				
	}
	private void initStartFrame(){
		
		
		startFrame.setSize(windowDefaultDimension);
		//Opening window in centered screen position
		startFrame.setLocationRelativeTo(null);
		//Program ends if window was closed
		startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//fix size of window... ->should be changed in later releases<-
		startFrame.setResizable(false);
		startFrame.setLayout(null);
		startFrame.getContentPane().setBackground(tableColor);
	}
	private void initVariableElements(){
		
		final SpinnerNumberModel spm1 = new SpinnerNumberModel( 1, 0, 10, 1 );
	    final JSpinner nrOfHPlayers = new JSpinner(spm1);
	    final SpinnerNumberModel spm2 = new SpinnerNumberModel( 100, 0, 999, 1 );
	    final JSpinner buyInSpinner = new JSpinner(spm2);
	    JLabel buttonLable = new JLabel("Start");
	    final JTextField[] playerNamesField = new JTextField[10];
	    final JLabel[] playersL = new JLabel[10];
	    
	    for(int i=0;i<10;i++){
	    	playerNamesField[i]= new JTextField();	    
	    	playersL[i]= new JLabel("Player "+(i+1)+":");
	    	playerNamesField[i].setBounds(450,(i+1)*23+20 , 300, 20);
	    	playersL[i].setBounds(380,(i+1)*23+20,300,20);
	    	
	    	playersL[i].setFont( new Font("Serif", Font.PLAIN, 14) );
		    playersL[i].setForeground( Color.BLACK );
	    	
	    	if(i==0){
	    		playerNamesField[i].setVisible(true);
	    		playersL[i].setVisible(true);
	    	} else {
	    		playerNamesField[i].setVisible(false);
	    		playersL[i].setVisible(false);
	    	}
	    	startFrame.add(playersL[i]);
	    	startFrame.add(playerNamesField[i]);
	    }	    
	    JButton startGame = new JButton();
	    startGame.setBounds(700, 370, 100, 35);
	    startGame.add(buttonLable);
	    
	    nrOfHPlayers.setBounds(300, 80, 45, 18);
	    buyInSpinner.setBounds(300, 100, 45, 18);
	    
	    buttonLable.setFont(new Font("Serif",Font.BOLD,20));
	    buttonLable.setForeground(Color.BLACK);
	    buttonLable.setBounds(1, 1, 100, 24);
	    
	    /**
	     * Start-Button Event Features:
	     * -Put main information to console (Players,BuyIn, ...etc.)
	     * -Set public Variables of Class
	     */
	    ActionListener startListener = new ActionListener() {
	        public void actionPerformed( ActionEvent e ) {
	        	
	        	System.out.println("Poker Game wird gestartet");
	        	System.out.println("Human Players:"+nrOfHPlayers.getValue());
	        	System.out.println("BuyIn:"+buyInSpinner.getValue());
	        	
	        	buyIn =(Integer) spm2.getValue();
	        	nrOfHumanPlayers =(Integer)spm1.getValue();
	        	playerNames = new String[nrOfHumanPlayers];
	        	for(int i=0;i<nrOfHumanPlayers;i++){
	        		playerNames[i]=playerNamesField[i].getText();
	        		System.out.println("Player"+(i+1)+": "+playerNames[i]);
	        	}
	        	
	        	//START GAME:
	        	//Poker game = new Poker();

	        }
	      };
	    
	    ChangeListener buyInChangeListener = new ChangeListener() {			
			@Override
			public void stateChanged(ChangeEvent e) {
				System.out.println("Human Players:"+nrOfHPlayers.getValue());
				for(int i=0;i<playerNamesField.length;i++){
					if(i > (Integer)nrOfHPlayers.getValue()-1){
						playerNamesField[i].setVisible(false);
						playersL[i].setVisible(false);
					} else{					
						playerNamesField[i].setVisible(true);
						playersL[i].setVisible(true);	
					}
				}				
			}
		};
	    
	    spm1.addChangeListener(buyInChangeListener);  
	    startGame.addActionListener(startListener);
	    
	    startFrame.add(startGame);
	    startGame.add(buttonLable);
	    startFrame.add(buyInSpinner);
	    startFrame.add(nrOfHPlayers);

	}	
}
