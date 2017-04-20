package miniProject;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import java.util.*;

class Menu extends JFrame implements ActionListener{
	JPanel panel;
    JPanel panelresult;
	private JButton b1;
	private JButton b2;
	private JButton b3;
    JLabel lblmess;  
	Menu()
	       {
	          setTitle("TEST ON SKILLS");
              setDefaultCloseOperation(EXIT_ON_CLOSE);
              setSize(1280,1024);
              setLocation(10,10);
              setResizable(true);
              Container cont=getContentPane();
              cont.setLayout(null);          
              cont.setBackground(Color.GRAY);                   
			  b1=new JButton("Quantitative Aptitude");
			  b2=new JButton("ENGLISH");
			  b3=new JButton("COMPUTER SCIENCE");
			  lblmess=new JLabel("CLICK TOPIC TO TAKE TEST");
              lblmess.setForeground(Color.BLUE);
              lblmess.setFont(new Font("Arial",Font.BOLD, 30));
              b1.addActionListener((ActionListener)this);
              b2.addActionListener((ActionListener)this);
              b3.addActionListener((ActionListener)this);
			    panel=new JPanel();
              panel.setBackground(Color.LIGHT_GRAY);
              panel.setLocation(0,0);
              panel.setSize(1280,1024);
              panel.setLayout(new GridLayout(6,2));
              panel.add(lblmess);
            panel.add(b1);
            panel.add(b2);
            panel.add(b3);
            cont.add(panel);
            setVisible(true);
	       }
	public void actionPerformed(ActionEvent e){
          if(e.getSource().equals(b1))
		  {
		       new Mymodule(1);
        	 
		  }
          else if(e.getSource().equals(b2))
          {
		    new Mymodule(1,2);
        	  
          }
          else if(e.getSource().equals(b3))
          {
		      new Mymodule(1,2,3);
        	  
          }
	}
	
}


 
class  Mymodule extends JFrame implements ActionListener{
JPanel panel;
JPanel panelresult;
JRadioButton choice1;
JRadioButton choice2;
JRadioButton choice3;
JRadioButton choice4;
ButtonGroup bg;
JLabel lblmess;
JButton btnext;
String[][] qpa;
String[][] qca;
int qaid,temp;
HashMap<Integer, String> map;
private int count1=0;
private int[] a=new int[10];
private int n;
Mymodule(int i)
{
    	
        Initializedata1(); 
    	setTitle("QUANTITATIVE APTITUDE");
    	create();
   
     }
Mymodule(int i,int j)
     {
    	  Initializedata2();
    	  setTitle("ENGLISH");
    	  create();
     }
Mymodule(int i,int j,int k)
     {
    	 Initializedata3();
    	 setTitle("COMPUTER SCIENCE");
    	 create();
     }
	public void create()
	{
      setDefaultCloseOperation(HIDE_ON_CLOSE);
      setSize(1024,728);
      setLocation(10,10);
      setResizable(false);
      Container cont=getContentPane();
      cont.setLayout(null);          
      cont.setBackground(Color.GRAY);                   
      bg=new ButtonGroup();     
    choice1=new JRadioButton("Choice1",true);
    choice2=new JRadioButton("Choice2",false);
    choice3=new JRadioButton("Choice3",false);
    choice4=new JRadioButton("Choice4",false);
    bg.add(choice1);
    bg.add(choice2);
    bg.add(choice3);
    bg.add(choice4);
    lblmess=new JLabel("Choose a correct anwswer :");
    lblmess.setForeground(Color.black);
    lblmess.setFont(new Font("Arial", Font.BOLD, 14));
    btnext=new JButton("Next");
    btnext.setForeground(Color.LIGHT_GRAY);                
    btnext.addActionListener(this);
    panel=new JPanel();
    panel.setBackground(Color.WHITE);
    panel.setLocation(0,0);
    panel.setSize(1024,728);
    panel.setLayout(new GridLayout(6,2));
    panel.add(lblmess);
    panel.add(choice1);
    panel.add(choice2);
    panel.add(choice3);
    panel.add(choice4);
    panel.add(btnext);
    cont.add(panel);
    setVisible(true);
    qaid=(int)(Math.random()*10);
    readqa(qaid);
    
    
   
}
	

public void actionPerformed(ActionEvent e){
                
        if(btnext.getText().equals("Next")){
                    
					if(count1<9){
                               qaid=(int)(Math.random()*10);
                                for(int i=0;i<a.length;i++)
                                {
                                	
                                	if (a[i]==qaid)
                                	{
                                		qaid= (int)(Math.random()*10);
                                		
                                	}
                                }
                                a[n]=qaid;
                                n++;
                                readqa(qaid);
                                count1++;
                                map.put(qaid,getSelection());
                                }
                    else {
                                
                                btnext.setText("Show answers");
                               
                             }
                    }
        else if(btnext.getText().equals("Show answers"))
                    new Report();
        
       
       
}

public void Initializedata1(){
    //qpa stores pairs of question and its possible answ
    qpa=new String[10][5];

    qpa[0][0]=" A pump can fill a tank with water in 2 hours."+" Because of a leak, it took 2 hours to fill the tank. The leak can drain all the water of the tank in:";
    qpa[0][1]="A. 4 1/3 hours";
    qpa[0][2]="b. 7 hours";
    qpa[0][3]="C. 8 hours";
    qpa[0][4]="D. 14 hours";

    qpa[1][0]=" 396, 462, 572, 427, 671, 264";
    qpa[1][1]="A. 396";
    qpa[1][2]="B. 427";
    qpa[1][3]="C. 671";
    qpa[1][4]="D. 264";
   
    qpa[2][0]=" A is thrice as good as workman as B and therefore is able to finish a job in 60 days less than B. Working together, they can do it in:";
    qpa[2][1]="A. 20 DAYS";
    qpa[2][2]="B. 22.5 DAYS";
    qpa[2][3]="C. 25 DAYS";
    qpa[2][4]="D. 30 DAYS";

    qpa[3][0]=" A is two years older than B who is twice as old as C. If the total of the ages of A, B and C be 27, the how old is B?";
    qpa[3][1]="A. 7";
    qpa[3][2]="B. 8";
    qpa[3][3]="C. 9";
    qpa[3][4]="D. 10";

    qpa[4][0]=" If one-third of one-fourth of a number is 15, then three-tenth of that number is:";
    qpa[4][1]="A. 35";
    qpa[4][2]="B. 36";
    qpa[4][3]="C. 45";
    qpa[4][4]="D. 54";

    qpa[5][0]=" The average of 20 numbers is zero. Of them, at the most, how many may be greater than zero?";
    qpa[5][1]="A. 19";
    qpa[5][2]="B. 0";
    qpa[5][3]="C. 1";
    qpa[5][4]="D. 10";

    qpa[6][0]=" If a person walks at 14 km/hr instead of 10 km/hr, he would have walked 20 km more. The actual distance travelled by him is:";
    qpa[6][1]="A. 56 KM";
    qpa[6][2]="B. 50 KM";
    qpa[6][3]="C. 70 KM";
    qpa[6][4]="D. 80 KM";

    qpa[7][0]=" In how many different ways can the letters of the word 'CORPORATION' be arranged so that the vowels always come together?";
    qpa[7][1]="A. 180";
    qpa[7][2]="B. 1440";
    qpa[7][3]="C. 50400";
    qpa[7][4]="D. 1880";

    qpa[8][0]=" 10, 25, 45, 54, 60, 75, 80";
    qpa[8][1]="A. 10";
    qpa[8][2]="B. 45";
    qpa[8][3]="C. 54";
    qpa[8][4]="D. 75";

    qpa[9][0]="  A fires 5 shots to B's 3 but A kills only once in 3 shots while B kills once in 2 shots. When B has missed 27 times, A has killed";
    qpa[9][1]="A. 30 BIRDS";
    qpa[9][2]="B. 60 BIRDS";
    qpa[9][3]="C. 75 BIRDS";
    qpa[9][4]="A. 75 BIRDS";

   
    //qca stores pairs of question and its correct answer
    qca=new String[10][2];
   
    qca[0][0]=" A pump can fill a tank with water in 2 hours. Because of a leak, it took 2 hours to fill the tank. The leak can drain all the water of the tank in:";
    qca[0][1]="D. 14 hours";

    qca[1][0]=" 396, 462, 572, 427, 671, 264";
    qca[1][1]="B. 427";

    qca[2][0]=" A is thrice as good as workman as B and therefore is able to finish a job in 60 days less than B. Working together, they can do it in:";
    qca[2][1]="B. 22.5 DAYS";

    qca[3][0]=" A is two years older than B who is twice as old as C. If the total of the ages of A, B and C be 27, the how old is B?";
    qca[3][1]="D. 10";


    qca[4][0]=" If one-third of one-fourth of a number is 15, then three-tenth of that number is:";
    qca[4][1]="D. 54";

    qca[5][0]=" The average of 20 numbers is zero. Of them, at the most, how many may be greater than zero?";
    qca[5][1]="A. 19";

    qca[6][0]=" If a person walks at 14 km/hr instead of 10 km/hr, he would have walked 20 km more. The actual distance travelled by him is:";
    qca[6][1]="B. 50 KM";
   
    qca[7][0]=" In how many different ways can the letters of the word 'CORPORATION' be arranged so that the vowels always come together?";
    qca[7][1]="C. 50400";
   
    qca[8][0]=" 10, 25, 45, 54, 60, 75, 80";
    qca[8][1]="C. 54";

    qca[9][0]=" A fires 5 shots to B's 3 but A kills only once in 3 shots while B kills once in 2 shots. When B has missed 27 times, A has killed";
    qca[9][1]="A. 30 BIRDS";
   
   
    //create a map object to store pairs of question and selected answer
    map=new HashMap<Integer, String>();
    
   
    }
public void Initializedata2(){
    //qpa stores pairs of question and its possible answers
    qpa=new String[10][5];

    qpa[0][0]="1. A pump can fill a tank with water in 2 hours. Because of a leak, it took 2 hours to fill the tank. The leak can drain all the water of the tank in:";
    qpa[0][1]="A. 4 1/3 hours";
    qpa[0][2]="b. 7 hours";
    qpa[0][3]="C. 8 hours";
    qpa[0][4]="D. 14 hours";

    qpa[1][0]="2. 396, 462, 572, 427, 671, 264";
    qpa[1][1]="A. 396";
    qpa[1][2]="B. 427";
    qpa[1][3]="C. 671";
    qpa[1][4]="D. 264";
   
    qpa[2][0]="3. A is thrice as good as workman as B and therefore is able to finish a job in 60 days less than B. Working together, they can do it in:";
    qpa[2][1]="A. 20 DAYS";
    qpa[2][2]="B. 22.5 DAYS";
    qpa[2][3]="C. 25 DAYS";
    qpa[2][4]="D. 30 DAYS";

    qpa[3][0]="4. A is two years older than B who is twice as old as C. If the total of the ages of A, B and C be 27, the how old is B?";
    qpa[3][1]="A. 7";
    qpa[3][2]="B. 8";
    qpa[3][3]="C. 9";
    qpa[3][4]="D. 10";

    qpa[4][0]="5. If one-third of one-fourth of a number is 15, then three-tenth of that number is:";
    qpa[4][1]="A. 35";
    qpa[4][2]="B. 36";
    qpa[4][3]="C. 45";
    qpa[4][4]="D. 54";

    qpa[5][0]="6. The average of 20 numbers is zero. Of them, at the most, how many may be greater than zero?";
    qpa[5][1]="A. 19";
    qpa[5][2]="B. 0";
    qpa[5][3]="C. 1";
    qpa[5][4]="D. 10";

    qpa[6][0]="7. If a person walks at 14 km/hr instead of 10 km/hr, he would have walked 20 km more. The actual distance travelled by him is:";
    qpa[6][1]="A. 56 KM";
    qpa[6][2]="B. 50 KM";
    qpa[6][3]="C. 70 KM";
    qpa[6][4]="D. 80 KM";

    qpa[7][0]="8. In how many different ways can the letters of the word 'CORPORATION' be arranged so that the vowels always come together?";
    qpa[7][1]="A. 180";
    qpa[7][2]="B. 1440";
    qpa[7][3]="C. 50400";
    qpa[7][4]="D. 1880";

    qpa[8][0]="9. 10, 25, 45, 54, 60, 75, 80";
    qpa[8][1]="A. 10";
    qpa[8][2]="B. 45";
    qpa[8][3]="C. 54";
    qpa[8][4]="D. 75";

    qpa[9][0]=" 10. A fires 5 shots to B's 3 but A kills only once in 3 shots while B kills once in 2 shots. When B has missed 27 times, A has killed";
    qpa[9][1]="A. 30 BIRDS";
    qpa[9][2]="B. 60 BIRDS";
    qpa[9][3]="C. 75 BIRDS";
    qpa[9][4]="A. 75 BIRDS";

   
    //qca stores pairs of question and its correct answer
    qca=new String[10][2];
   
    qca[0][0]="1. A pump can fill a tank with water in 2 hours. Because of a leak, it took 2 hours to fill the tank. The leak can drain all the water of the tank in:";
    qca[0][1]="D. 14 hours";

    qca[1][0]="2. 396, 462, 572, 427, 671, 264";
    qca[1][1]="B. 427";

    qca[2][0]="3. A is thrice as good as workman as B and therefore is able to finish a job in 60 days less than B. Working together, they can do it in:";
    qca[2][1]="B. 22.5 DAYS";

    qca[3][0]="4. A is two years older than B who is twice as old as C. If the total of the ages of A, B and C be 27, the how old is B?";
    qca[3][1]="D. 10";


    qca[4][0]="5. If one-third of one-fourth of a number is 15, then three-tenth of that number is:";
    qca[4][1]="D. 54";

    qca[5][0]="6. The average of 20 numbers is zero. Of them, at the most, how many may be greater than zero?";
    qca[5][1]="A. 19";

    qca[6][0]="7. If a person walks at 14 km/hr instead of 10 km/hr, he would have walked 20 km more. The actual distance travelled by him is:";
    qca[6][1]="B. 50 KM";
   
    qca[7][0]="8. In how many different ways can the letters of the word 'CORPORATION' be arranged so that the vowels always come together?";
    qca[7][1]="C. 50400";
   
    qca[8][0]="9. 10, 25, 45, 54, 60, 75, 80";
    qca[8][1]="C. 54";

    qca[9][0]="10. A fires 5 shots to B's 3 but A kills only once in 3 shots while B kills once in 2 shots. When B has missed 27 times, A has killed";
    qca[9][1]="A. 30 BIRDS";
   
   
    //create a map object to store pairs of question and selected answer
    map=new HashMap<Integer, String>();
   
}
public void Initializedata3(){
    //qpa stores pairs of question and its possible answer
    qpa=new String[10][5];

    qpa[0][0]="1. A pump can fill a tank with water in 2 hours. Because of a leak, it took 2 hours to fill the tank. The leak can drain all the water of the tank in:";
    qpa[0][1]="A. 4 1/3 hours";
    qpa[0][2]="b. 7 hours";
    qpa[0][3]="C. 8 hours";
    qpa[0][4]="D. 14 hours";

    qpa[1][0]="2. 396, 462, 572, 427, 671, 264";
    qpa[1][1]="A. 396";
    qpa[1][2]="B. 427";
    qpa[1][3]="C. 671";
    qpa[1][4]="D. 264";
   
    qpa[2][0]="3. A is thrice as good as workman as B and therefore is able to finish a job in 60 days less than B. Working together, they can do it in:";
    qpa[2][1]="A. 20 DAYS";
    qpa[2][2]="B. 22.5 DAYS";
    qpa[2][3]="C. 25 DAYS";
    qpa[2][4]="D. 30 DAYS";

    qpa[3][0]="4. A is two years older than B who is twice as old as C. If the total of the ages of A, B and C be 27, the how old is B?";
    qpa[3][1]="A. 7";
    qpa[3][2]="B. 8";
    qpa[3][3]="C. 9";
    qpa[3][4]="D. 10";

    qpa[4][0]="5. If one-third of one-fourth of a number is 15, then three-tenth of that number is:";
    qpa[4][1]="A. 35";
    qpa[4][2]="B. 36";
    qpa[4][3]="C. 45";
    qpa[4][4]="D. 54";

    qpa[5][0]="6. The average of 20 numbers is zero. Of them, at the most, how many may be greater than zero?";
    qpa[5][1]="A. 19";
    qpa[5][2]="B. 0";
    qpa[5][3]="C. 1";
    qpa[5][4]="D. 10";

    qpa[6][0]="7. If a person walks at 14 km/hr instead of 10 km/hr, he would have walked 20 km more. The actual distance travelled by him is:";
    qpa[6][1]="A. 56 KM";
    qpa[6][2]="B. 50 KM";
    qpa[6][3]="C. 70 KM";
    qpa[6][4]="D. 80 KM";

    qpa[7][0]="8. In how many different ways can the letters of the word 'CORPORATION' be arranged so that the vowels always come together?";
    qpa[7][1]="A. 180";
    qpa[7][2]="B. 1440";
    qpa[7][3]="C. 50400";
    qpa[7][4]="D. 1880";

    qpa[8][0]="9. 10, 25, 45, 54, 60, 75, 80";
    qpa[8][1]="A. 10";
    qpa[8][2]="B. 45";
    qpa[8][3]="C. 54";
    qpa[8][4]="D. 75";

    qpa[9][0]=" 10. A fires 5 shots to B's 3 but A kills only once in 3 shots while B kills once in 2 shots. When B has missed 27 times, A has killed";
    qpa[9][1]="A. 30 BIRDS";
    qpa[9][2]="B. 60 BIRDS";
    qpa[9][3]="C. 75 BIRDS";
    qpa[9][4]="A. 75 BIRDS";

   
    //qca stores pairs of question and its correct answer
    qca=new String[10][2];
   
    qca[0][0]="1. A pump can fill a tank with water in 2 hours. Because of a leak, it took 2 hours to fill the tank. The leak can drain all the water of the tank in:";
    qca[0][1]="D. 14 hours";

    qca[1][0]="2. 396, 462, 572, 427, 671, 264";
    qca[1][1]="B. 427";

    qca[2][0]="3. A is thrice as good as workman as B and therefore is able to finish a job in 60 days less than B. Working together, they can do it in:";
    qca[2][1]="B. 22.5 DAYS";

    qca[3][0]="4. A is two years older than B who is twice as old as C. If the total of the ages of A, B and C be 27, the how old is B?";
    qca[3][1]="D. 10";


    qca[4][0]="5. If one-third of one-fourth of a number is 15, then three-tenth of that number is:";
    qca[4][1]="D. 54";

    qca[5][0]="6. The average of 20 numbers is zero. Of them, at the most, how many may be greater than zero?";
    qca[5][1]="A. 19";

    qca[6][0]="7. If a person walks at 14 km/hr instead of 10 km/hr, he would have walked 20 km more. The actual distance travelled by him is:";
    qca[6][1]="B. 50 KM";
   
    qca[7][0]="8. In how many different ways can the letters of the word 'CORPORATION' be arranged so that the vowels always come together?";
    qca[7][1]="C. 50400";
   
    qca[8][0]="9. 10, 25, 45, 54, 60, 75, 80";
    qca[8][1]="C. 54";

    qca[9][0]="10. A fires 5 shots to B's 3 but A kills only once in 3 shots while B kills once in 2 shots. When B has missed 27 times, A has killed";
    qca[9][1]="A. 30 BIRDS";
   
   
    //create a map object to store pairs of question and selected answer
    map=new HashMap<Integer, String>();
   
}


public String getSelection(){
        String selectedChoice=null;
        Enumeration<AbstractButton> buttons=bg.getElements(); 
        while(buttons.hasMoreElements()) 
        { 
        JRadioButton temp=(JRadioButton)buttons.nextElement(); 
        if(temp.isSelected()) 
                    { 
                                selectedChoice=temp.getText();
                    } 
         }  
        return(selectedChoice);
}


public void readqa(int qid){
        lblmess.setText("  "+qpa[qid][0]);
        choice1.setText(qpa[qid][1]);
        choice2.setText(qpa[qid][2]);
        choice3.setText(qpa[qid][3]);
        choice4.setText(qpa[qid][4]);
        choice1.setSelected(true);
}
public void reset(){
        qaid=0;
        map.clear();
        readqa(qaid);
        btnext.setText("Next");
        }
public int calCorrectAnswer(){
        int qnum=10;
        int count=0;
        for(int qid=0;qid<qnum;qid++)
                    if(qca[qid][1].equals(map.get(qid))) count++;
        return count;
}

public class Report extends JFrame{
        Report(){
                    setTitle("Answers");
                    setSize(1280,1024);
                    setBackground(Color.WHITE);
                    addWindowListener(new WindowAdapter(){
                                            public void windowClosing(WindowEvent e){
                                            	        dispose();
                                                        reset();
                                            }
                                });
                    Draw d=new Draw();                                  
                    add(d);
                    setVisible(true);
                    }
       
       
    class Draw extends Canvas{
                    public void paint(Graphics g){
                    	         int numc=calCorrectAnswer();
                    	         g.setColor(Color.blue);
                    	         g.setFont(new Font("Arial",Font.BOLD,20));
                    	         g.drawString("Number of correct answers:    " +numc,300,200 );
                                //Show number of correct answers
                               
                                g.setColor(Color.RED);
                                g.setFont(new Font("Arial",Font.BOLD,20));
                                g.drawString("   THANK YOU",300,400);
                                g.drawString("   GO TO MAIN MENU FOR NEXT MODULE....!!!!",200,500);
       
                               
                    }
        }
                   
}
}



public  class myProject {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new Menu();

	}

}
