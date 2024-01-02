package application;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
public class SampleController implements Initializable{
	@FXML
	AnchorPane anchorpane;
	@FXML
	ImageView myimgview,myimgview2;
	@FXML
	Button startbutton;
	@FXML
	Button restartbutton;
	@FXML
	Label destination;
	@FXML
	ImageView onewin,oneloss,twowin,twoloss,draw;
	int answer1=-1,answer2=-1;
	int totalimg=15;
	int[] anslist= {3,1,2,3,3,1,4,2,4,2,4,3,1,1,2};
	int[] anslist2= {2,2,4,1,4,2,4,2,2,1,3,2,3,1,3};
	int k1=1;
	int[] ase1= {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	int k2=1;
	int[] ase2= {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	boolean bul=false; 
	private List<ImageView> all =new ArrayList<>();
	private List<ImageView> al = new ArrayList<>();
	int s=0,t=0;
	@FXML
	void restart(ActionEvent event) throws IOException {
		
			Parent root = FXMLLoader.load(getClass().getResource("gmpg.fxml"));
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
	}
	@FXML
	ImageView im1,im2,im3,im4,im5,im6,im7,im8,im9,im10,im11,im12,im13,im14,im15,img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12,img13,img14,img15;
	@FXML
	void startGame(ActionEvent event) {
//		startbutton.setVisible(false);
		s=1;
		startbutton.setLayoutX(-1000);
		all.add(img1);
		all.add(img2);
		all.add(img3);
		all.add(img4);
		all.add(img5);
		all.add(img6);
		all.add(img7);
		all.add(img8);
		all.add(img9);
		all.add(img10);
		all.add(img11);
		all.add(img12);
		all.add(img13);
		all.add(img14);
		all.add(img15);	
		al.add(im1);
		al.add(im2);
		al.add(im3);
		al.add(im4);
		al.add(im5);
		al.add(im6);
		al.add(im7);
		al.add(im8);
		al.add(im9);
		al.add(im10);
		al.add(im11);
		al.add(im12);
		al.add(im13);
		al.add(im14);
		al.add(im15);	
		
		imagePalta();
		imagePalta2();
	}
	void imagePalta() {
		int r= (int)(Math.random()*100);
		System.out.println(r);
//		r=r%2;
		r = r%15;
		while(ase1[r]==1)
		{
			r=(int)(Math.random()*100);
			r=r%15;
			if(k1>=15)break;
		}
		ase1[r]=1;
		k1++;
		all.get(r).setVisible(true);
		answer1=anslist[r];
		for(int i=0;i<totalimg;i++)
		{
			if(i!=r)
			{
				all.get(i).setVisible(false);
			}
		}
	}
	void imagePalta2() {
		int r= (int)(Math.random()*100);
		System.out.println(r);
//		r=r%2;
		r = r%15;
		while(ase2[r]==1)
		{
			r=(int)(Math.random()*100);
			r=r%15;
			if(k2>=15)break;
		}
		ase2[r]=1;
		k2++;
		al.get(r).setVisible(true);
		answer2=anslist2[r];
		for(int i=0;i<totalimg;i++)
		{
			if(i!=r)
			{
				al.get(i).setVisible(false);
			}
		}
	}
	private BooleanProperty aPressed = new SimpleBooleanProperty();
    private BooleanProperty bPressed = new SimpleBooleanProperty();
    private BooleanProperty cPressed = new SimpleBooleanProperty();
    private BooleanProperty dPressed = new SimpleBooleanProperty();
    
    private BooleanProperty Pressed1 = new SimpleBooleanProperty();
    private BooleanProperty Pressed2 = new SimpleBooleanProperty();
    private BooleanProperty Pressed3 = new SimpleBooleanProperty();
    private BooleanProperty Pressed4 = new SimpleBooleanProperty();
    
    private BooleanBinding keyPressed = aPressed.or(bPressed).or(cPressed).or(dPressed).or(Pressed1).or(Pressed2).or(Pressed3).or(Pressed4);
    
    AnimationTimer timer1 = new AnimationTimer() {
        @Override
        public void handle(long timestamp) {

            if(aPressed.get()) {
            	if(s==1 && t==0) {
            	if(answer1==1) {
            		myimgview.setLayoutY(myimgview.getLayoutY()-69);
            	}
            	if(myimgview.getLayoutY()+myimgview.getFitHeight()<=destination.getLayoutY())
            	{
            		System.out.println(" cad");
            		onewin.setVisible(true);
            		twoloss.setVisible(true);
            		restartbutton.setVisible(true);
            		t=1;
            	}
        		if(k1>15)
        		{
        			System.out.println(" cad2");
        			twowin.setVisible(true);
            		oneloss.setVisible(true);
            		restartbutton.setVisible(true);
            		t=1;
        		}
        		else
        		{
        			imagePalta();
        		}
            	}
            	aPressed.set(false);
            }
            if(bPressed.get()){
            	if(s==1 && t==0) {
            	if(answer1==2) {
            		myimgview.setLayoutY(myimgview.getLayoutY()-69);
            	}
            	if(myimgview.getLayoutY()+myimgview.getFitHeight()<=destination.getLayoutY())
            	{
            		onewin.setVisible(true);
            		twoloss.setVisible(true);
            		restartbutton.setVisible(true);
            		t=1;
            	}
        		if(k1>15)
        		{
        			twowin.setVisible(true);
            		oneloss.setVisible(true);
            		restartbutton.setVisible(true);
            		t=1;
        		}
        		else
        		{
        			imagePalta();
        		}
            	}
            	bPressed.set(false);
            }
            if(cPressed.get()) {
            	if(s==1 && t==0) {
            	if(answer1==3) {
            		myimgview.setLayoutY(myimgview.getLayoutY()-69);
            	}
            	if(myimgview.getLayoutY()+myimgview.getFitHeight()<=destination.getLayoutY())
            	{
            		onewin.setVisible(true);
            		twoloss.setVisible(true);
            		restartbutton.setVisible(true);
            		t=1;
            	}
        		if(k1>15)
        		{
        			twowin.setVisible(true);
            		oneloss.setVisible(true);
            		restartbutton.setVisible(true);
            		t=1;
        		}
        		else
        		{
        			imagePalta();
        		}
            	}
            	cPressed.set(false);
            }
            if(dPressed.get()) {
            	if(s==1 && t==0) {
            	if(answer1==4) {
            		myimgview.setLayoutY(myimgview.getLayoutY()-69);
            	}
            	if(myimgview.getLayoutY()+myimgview.getFitHeight()<=destination.getLayoutY())
            	{
            		onewin.setVisible(true);
            		twoloss.setVisible(true);
            		restartbutton.setVisible(true);
            		t=1;
            	}
        		if(k1>15)
        		{
        			twowin.setVisible(true);
            		oneloss.setVisible(true);
            		restartbutton.setVisible(true);
            		t=1;
        		}
        		else
        		{
        			imagePalta();
        		}
            	}
            	dPressed.set(false);
            }
            if(Pressed1.get()) {
            	if(s==1 && t==0) {
            	if(answer2==1) {
            		myimgview2.setLayoutY(myimgview2.getLayoutY()-69);
            	}
            	if(myimgview2.getLayoutY()+myimgview2.getFitHeight()<=destination.getLayoutY())
            	{
            		twowin.setVisible(true);
            		oneloss.setVisible(true);
            		restartbutton.setVisible(true);
            		t=1;
            	}
        		if(k2>15)
        		{
        			onewin.setVisible(true);
            		twoloss.setVisible(true);
            		restartbutton.setVisible(true);
            		t=1;
        		}
        		else
        		{
        			imagePalta2();
        		}
            	}
            	Pressed1.set(false);
            }
            if(Pressed2.get()){
            	if(s==1 && t==0) {
            	if(answer2==2) {
            		myimgview2.setLayoutY(myimgview2.getLayoutY()-69);
            	}
            	if(myimgview2.getLayoutY()+myimgview2.getFitHeight()<=destination.getLayoutY())
            	{
            		twowin.setVisible(true);
            		oneloss.setVisible(true);
            		restartbutton.setVisible(true);
            		t=1;
            	}
        		if(k2>15)
        		{
        			onewin.setVisible(true);
            		twoloss.setVisible(true);
            		restartbutton.setVisible(true);
            		t=1;
        		}
        		else
        		{
        			imagePalta2();
        		}
            	}
            	Pressed2.set(false);
            }
            if(Pressed3.get()) {
            	if(s==1 && t==0) {
            	if(answer2==3) {
            		myimgview2.setLayoutY(myimgview2.getLayoutY()-69);
            	}
            	if(myimgview2.getLayoutY()+myimgview2.getFitHeight()<=destination.getLayoutY())
            	{
            		twowin.setVisible(true);
            		oneloss.setVisible(true);
            		restartbutton.setVisible(true);
            		t=1;
            	}
        		if(k2>15)
        		{
        			onewin.setVisible(true);
            		twoloss.setVisible(true);
            		restartbutton.setVisible(true);
            		t=1;
        		}
        		else
        		{
        			imagePalta2();
        		}
            	}
            	Pressed3.set(false);
            }
            if(Pressed4.get()) {
            	if(s==1 && t==0) {
            	if(answer2==4) {
            		myimgview2.setLayoutY(myimgview2.getLayoutY()-69);
            	}
            	if(myimgview2.getLayoutY()+myimgview2.getFitHeight()<=destination.getLayoutY())
            	{
            		twowin.setVisible(true);
            		oneloss.setVisible(true);
            		restartbutton.setVisible(true);
            		t=1;
            	}
        		if(k2>15)
        		{
        			onewin.setVisible(true);
            		twoloss.setVisible(true);
            		restartbutton.setVisible(true);
            		t=1;
        		}
        		else
        		{
        			imagePalta2();
        		}
            	}
            	Pressed4.set(false);
            }
            
        }
    };
    
    public void setup(){
        anchorpane.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent e) {
			    if(e.getCode() == KeyCode.A) {
			        aPressed.set(true);
			    }

			    if(e.getCode() == KeyCode.B) {
			        bPressed.set(true);
			    }
			    if(e.getCode() == KeyCode.C) {
			        cPressed.set(true);
			    }

			    if(e.getCode() == KeyCode.D) {
			        dPressed.set(true);
			    }
			    if(e.getCode() == KeyCode.DIGIT1) {
			        Pressed1.set(true);
			    }

			    if(e.getCode() == KeyCode.DIGIT2) {
			        Pressed2.set(true);
			    }
			    if(e.getCode() == KeyCode.DIGIT3) {
			        Pressed3.set(true);
			    }

			    if(e.getCode() == KeyCode.DIGIT4) {
			        Pressed4.set(true);
			    }
			}
		});

        anchorpane.setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent e) {
			    if(e.getCode() == KeyCode.A) {
			        aPressed.set(false);	
			    }

			    if(e.getCode() == KeyCode.B) {
			        bPressed.set(false);
			    }
			    if(e.getCode() == KeyCode.C) {
			        cPressed.set(false);
			    }

			    if(e.getCode() == KeyCode.D) {
			        dPressed.set(false);
			    }
			    if(e.getCode() == KeyCode.DIGIT1) {
			        Pressed1.set(false);
			    }

			    if(e.getCode() == KeyCode.DIGIT2) {
			        Pressed2.set(false);
			    }
			    if(e.getCode() == KeyCode.DIGIT3) {
			        Pressed3.set(false);
			    }

			    if(e.getCode() == KeyCode.DIGIT4) {
			        Pressed4.set(false);
			    }
			}
		});
    }

	public void initialize(URL arg0, ResourceBundle arg1) {
		setup();
        keyPressed.addListener((new ChangeListener<Boolean>() {
			public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
			    if(!aBoolean){
			        timer1.start();
			    } else {
			        timer1.stop();
			    }
			}
		}));
	}
	@FXML
	public void backtohome(ActionEvent event)throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
	}

}