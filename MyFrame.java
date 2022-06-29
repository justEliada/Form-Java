import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;
import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;

//JFrame parent class -> duke perdorur trazhgimine
class MyFrame extends JFrame implements ActionListener {  //kupton veprimet e user 

   //JFrame frame = new JFrame (); konstruktor , qe krijon nje frame te ri 
    private JLabel title;// private = restricted access
    private JLabel labelEmri ;
    private JTextField textEmri;  
    private JLabel labelMbimri ;
    private JTextField textMbimri;
    private JLabel gjinia;
    private JRadioButton mashkull; // buton merr nje op nga disa opsione
    private JRadioButton femer;
    private ButtonGroup grup;  // grup butonash femer/mashkull
    private JLabel mosha;
    private JComboBox datat_e_muajit;
    private JComboBox muajt;
    private JComboBox viti;
    private JLabel add;
    private JLabel ID;
    private JTextField kartaID;
    private JTextArea adresaAdd;
    private JCheckBox term;
    private JButton sub;
    private JButton reset;
    private JTextArea teksti_i_dale; // kutia ku dalin te dhenat
    private JLabel rregjistrimiISuk;  //nqs rregjistrimi i sukseshem 
    private JTextArea rregjistrimiReset;  // nqs rregjistrmi duhet te ribehet
    private Container kontenitori;
    private JLabel Emri_Mbiemri;
    private JTextField emri_mbiemri;
    private JLabel passwordi;
    private JTextField passWord;
    private JButton hyr;
    private JLabel admin;
    private JRadioButton shto;
    private JRadioButton ndrysho;
    private JRadioButton fshi;
    private JLabel balanca;
    private JTextField balancaField;
    private JTextArea balanca_e_printuar;
    private JButton ok;
    private JLabel kontakt;
    private ButtonGroup grup1;

    
 
    private String dates[]
        = { "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31" };
    private String months[]
        = { "Janar", "Shkurt", "Mars", "Prill",
            "Maj", "Qershor", "Korrik", "Gusht",
            "Shtator", "Tetor", "Nentor", "Dhjetor" };
    private String years[]
        = { "1999", "2000", "2001", "2002",
            "2003", "2004", "2005", "2006",
            "2007", "2008", "2009", "2010",
            "2011", "2012", "2013", "2014",
            "2015", "2016", "2017", "2018",
            "2019" };

    
        //Konstruktori myframe
    public MyFrame() throws IOException
    {
        this.setTitle("Formular");  //ketu vendoset titulli i frame
        this.setBounds(300, 90, 600, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // del nga aplikoacioni
        this.setResizable(true); // na lejon mundesine to change the size 
        this.getContentPane().setBackground(new Color(255,245,238));
        
       // this.setLayout(new FlowLayout(FlowLayout.LEFT)); //si default - border layout/ vendosim flow 
        kontenitori = getContentPane();
        kontenitori.setLayout(null ); // layout per label vendoset ne menyre manuale

        // nisim me te dhenat e formularitt
        title = new JLabel("Formular i rregjistrimit ne Banke");
        title.setFont(new Font("Serif", Font.ITALIC, 29));
        title.setSize(400, 30);
        title.setLocation(100, 15);
        title.setForeground(new Color (34,139,34));
        kontenitori.add(title);
       
        // nisim me te dhenat e menuse
        JMenuBar menuBar = new JMenuBar(); 
        setJMenuBar(menuBar);

        // klienti -> opsionet  nga menu
        JMenu menu1 = new JMenu("MENU KLIENT");
        menuBar.add(menu1);
        JMenuItem opsioni1 = new JMenuItem("1. Balanca");  // vendos balancen pordoruesi e cila vendoset ne file
        opsioni1.addActionListener(this);
        menu1.add(opsioni1);
        JMenuItem opsioni2 = new JMenuItem("2. Transaksione");   // perdoruesi shikon transaksionet e kryera 
        opsioni2.addActionListener(this);
        menu1.add(opsioni2);
        JMenuItem opsioni3 = new JMenuItem("3. Terhqeje parash");
        opsioni3.addActionListener(this);
        menu1.add(opsioni3);
        JMenuItem opsioni4 = new JMenuItem("4. Dilni nga account"); // direkt jepet komanda exit on open
        opsioni4.addActionListener(this);
        menu1.add(opsioni4);
        JMenuItem opsioni5 = new JMenuItem("5. Kontaktoni Adminin");  // shfaqet adresa e email + numer cel ne rast emergjence 
        opsioni5.addActionListener(this);
        menu1.add(opsioni5);



        // OPSIONI 1 
        JFrame f1 = new JFrame ();   // Krijojem nje frame te re qe do te hapet pas klikimit
        f1.setSize(400,400);
        f1.setTitle("Kontrolloni Balancen tuaj ");
        f1.setBounds(500, 500, 500, 500);
        f1.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f1.setResizable(false); 
        f1.setLayout(null );
        f1.getContentPane().setBackground(new Color(255,245,238));


        // secila ka label dhe perkrah vendin ku mund te deklarohen te dhenat 
        balanca = new JLabel();
        balanca.setText("Vendosni blancen tuaj ");   
        balanca.setSize(150,30);
        balanca.setLocation(50, 100);
        balanca.setFont(new Font("Serif", Font.BOLD, 15));
        f1.add(balanca);

        balancaField = new JTextField();
        balancaField.setSize(200,20);
        balancaField.setLocation(250, 100);
        f1.add(balancaField);


        balanca_e_printuar = new JTextArea();
        balanca_e_printuar.setFont(new Font("Serif", Font.PLAIN, 15));
        balanca_e_printuar.setSize(200 , 35);
        balanca_e_printuar.setLocation(250, 150);
        balanca_e_printuar.setLineWrap(true);
        balanca_e_printuar.setEditable(false);
        f1.add(balanca_e_printuar);


        ok = new JButton("OK");
        ok.setFont(new Font("Serif", Font.PLAIN, 17));
        ok.setSelected(true);
        ok.setSize(100, 30);
        ok.setLocation(200,200);
        ok.setBackground(new Color (0, 122, 153)); 
        ok.setOpaque(true); 
        ok.setBorderPainted(true);  
        f1.add(ok);
        
        opsioni1.addActionListener(new ActionListener()
         {
             public void actionPerformed (ActionEvent a ){
                 f1.setVisible(true);
                 if (ok.isSelected()){
                 String data7 = "Balanca juaj eshte: " + balancaField.getText();
                 balanca_e_printuar.setText(data7);
                 balanca_e_printuar.setEditable(false);}


 
             }
         });

        //Opsioni 5 
        JFrame f5 = new JFrame ();   // Krijojem nje frame te re qe do te hapet pas klikimit
        f5.setSize(600,150);
        f5.setTitle("Kontaktoni adminin ");
        f5.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f5.setResizable(false); 
        f5.setLayout(null );
        f5.getContentPane().setBackground(new Color(255,245,238));


        kontakt = new JLabel();
        kontakt.setText("Kontaktoni nepermjet:" + "\n" 
        +"EMAIL : eliadaballazhi20@umt.edu.al"+
         "\n" + "CEL : 012345678");   
        kontakt.setSize(600,200);
        kontakt.setLocation(0, 0);
        kontakt.setFont(new Font("Serif", Font.BOLD, 15));
        f5.add(kontakt);

        opsioni5.addActionListener(new ActionListener()
        {
            public void actionPerformed (ActionEvent e){
                f5.setVisible(true);

            }
        });

        // Opsioni 4 
        opsioni4.addActionListener(new ActionListener()
        {
            public void actionPerformed (ActionEvent e){
                dispose();

            }
        });

        //administratiori -> opsionet 
        JMenu menu2 = new JMenu("MENU ADMINISTRATOR");
        menuBar.add(menu2);
        JMenuItem opsioni6 = new JMenuItem("1. Futuni ne sistem ");
        opsioni6.addActionListener(this);
        menu2.add(opsioni6);
        
       
        // krijon nje frame te re qe te beje log in administratori
        JFrame f = new JFrame ();
        f.setSize(600,650);
        f.setTitle("LOG IN NE SISTEM");
        f.setResizable(false); 
        f.setLayout(null );// na lejon te modifikojme sipas deshires framin e ri 

        Emri_Mbiemri = new JLabel();
        Emri_Mbiemri.setText("Perdoruesi: ");
        Emri_Mbiemri.setBackground(new Color(230, 249, 255));
        Emri_Mbiemri.setOpaque(true);   
        Emri_Mbiemri.setSize(100,20);
        Emri_Mbiemri.setLocation(100, 100);
        Emri_Mbiemri.setFont(new Font("Serif", Font.BOLD, 15));
        f.add(Emri_Mbiemri);

        emri_mbiemri = new JTextField();
        emri_mbiemri.setSize(200,20);
        emri_mbiemri.setLocation(200, 100);
        f.add(emri_mbiemri);


        passwordi = new JLabel();
        passwordi.setText("Passwordi: ");
        passwordi.setSize(100,20);
        passwordi.setLocation(100,150);
        passwordi.setBackground(new Color(230, 249, 255));
        passwordi.setOpaque(true); 
        passwordi.setFont(new Font("Serif", Font.BOLD, 15));
        f.add(passwordi);

       
        passWord = new JTextField();
        passWord.setSize(200,20);
        passWord.setLocation(200,150);
        f.add(passWord);

        shto = new JRadioButton("SHTO TE DHENAT");
        shto.setFont(new Font("Serif",Font.ROMAN_BASELINE, 15));
        shto.setSelected(true);
        shto.setSize(200, 200);
        shto.setLocation(0, 250);
        f.add(shto);
      

        ndrysho = new JRadioButton("NDRYSHO TE DHENAT");
        ndrysho.setFont(new Font("Serif", Font.ROMAN_BASELINE, 15));
        ndrysho.setSelected(false);
        ndrysho.setSize(200, 200);
        ndrysho.setLocation(200, 250);
        f.add(ndrysho);

        fshi = new JRadioButton("FSHI TE DHENAT");
        fshi.setFont(new Font("Serif",Font.ROMAN_BASELINE, 15));
        fshi.setSelected(false);
        fshi.setSize(200, 200);
        fshi.setLocation(400, 250);  
        f.add(fshi);
    
        grup1 = new ButtonGroup();  // ben te mundur te zgjidhet vtm nje nga opsionet 
        grup1.add(ndrysho);
        grup1.add(shto);
        grup1.add(fshi);

        

        hyr = new JButton("Log in ");
        hyr.setFont(new Font("Serif", Font.PLAIN, 17));
        hyr.setSelected(true);
        hyr.setSize(100, 30);
        hyr.setLocation(200,200);
        hyr.setBackground(new Color (0, 122, 153)); 
        hyr.setOpaque(true); 
        hyr.setBorderPainted(true); // kur eshte true me ngjyren qe zgjedhim printohet vetm si border 
        hyr.addActionListener(new ActionListener(){
        

            public void actionPerformed (ActionEvent e ){
                if (e.getSource() == hyr){
                    admin.setText("Rregjistrimi sukses! ");
                }
                else {
                    admin.setText("ERROR, PROVONI PERSERI!");
                }

            }
        });

        f.add(hyr);

        admin = new JLabel();
        admin.setFont(new Font("Serif", Font.PLAIN, 20));
        admin.setSize(200,200);
        admin.setLocation(200,200);

        f.add(admin);

        opsioni6.addActionListener(new ActionListener()
         {
             public void actionPerformed (ActionEvent e ){
                 f.setVisible(true);
                 dispose();  // mbyll old frame ne momentin qe hapet new frame (log in)
 
             }
         });


        String file = "c:\\new.txt"; // te dhenat qe merren nga perdoruesi ruhen ne nje file
        FileWriter fileWriter = new FileWriter(file); // konstruktori qe krijon new file

        labelEmri = new JLabel("Emri");
        labelEmri.setFont(new Font("Serif", Font.PLAIN, 20));
        labelEmri.setSize(100, 20);
        labelEmri.setLocation(100, 100);
        kontenitori.add(labelEmri); // i ben add to frame -> dont forget 
 
        textEmri = new JTextField();
        textEmri.setFont(new Font("Serif", Font.PLAIN, 15));
        textEmri.setSize(190, 20);
        textEmri.setLocation(200, 100);
        textEmri.write(fileWriter);
        kontenitori.add(textEmri); // i ben add emrin ne frame , vendoset ne cdo gje qe i shtohet frame
        

        labelMbimri = new JLabel("Mbiemri");
        labelMbimri.setFont(new Font("Serif", Font.PLAIN, 20));
        labelMbimri.setSize(100, 20);
        labelMbimri.setLocation(100, 150);
        kontenitori.add(labelMbimri);
 
        textMbimri = new JTextField();
        textMbimri.setFont(new Font("Serif", Font.PLAIN, 15));
        textMbimri.setSize(190, 20);
        textMbimri.setLocation(200, 150);
        textMbimri.write(fileWriter);
        kontenitori.add(textMbimri);
 
        gjinia = new JLabel("Gjinia");
        gjinia.setFont(new Font("Serif", Font.PLAIN, 20));
        gjinia.setSize(100, 20);
        gjinia.setLocation(100, 250);
        kontenitori.add(gjinia);
        

        //Radiobutton me 2 opsione ku mund te zgjedhesh
        mashkull = new JRadioButton("M");
        mashkull.setFont(new Font("Serif", Font.PLAIN, 15));
        mashkull.setSelected(true);
        mashkull.setSize(75, 20);
        mashkull.setLocation(200, 250);
        kontenitori.add(mashkull);
 
        femer = new JRadioButton("F");
        femer.setFont(new Font("Serif", Font.PLAIN, 15));
        femer.setSelected(false);
        femer.setSize(100, 20);
        femer.setLocation(275, 250);
        kontenitori.add(femer);
 
        grup = new ButtonGroup();
        grup.add(mashkull);
        grup.add(femer);
 
        mosha = new JLabel("Mosha");
        mosha.setFont(new Font("Serif", Font.PLAIN, 20));
        mosha.setSize(100, 20);
        mosha.setLocation(100, 300);
        kontenitori.add(mosha);
 
        datat_e_muajit = new JComboBox(dates);
        datat_e_muajit.setFont(new Font("Serif", Font.PLAIN, 15));
        datat_e_muajit.setSize(100, 20);
        datat_e_muajit.setLocation(200, 300);
        kontenitori.add(datat_e_muajit);
 
        muajt = new JComboBox(months);
        muajt.setFont(new Font("Serif", Font.PLAIN, 15));
        muajt.setSize(100, 20);
        muajt.setLocation(300, 300);
        kontenitori.add(muajt);
 
        viti = new JComboBox(years);
        viti.setFont(new Font("Serif", Font.PLAIN, 15));
        viti.setSize(100, 20);
        viti.setLocation(400, 300);
        kontenitori.add(viti);
 
        add = new JLabel("Adresa");
        add.setFont(new Font("Serif", Font.PLAIN, 20));
        add.setSize(100, 20);
        add.setLocation(100, 350);
        kontenitori.add(add);

        adresaAdd = new JTextArea();
        adresaAdd.setFont(new Font("Serif", Font.PLAIN, 15));
        adresaAdd.setSize(200, 75);
        adresaAdd.setLocation(200, 350);
        adresaAdd.setLineWrap(true);
        kontenitori.add(adresaAdd);
 

        ID = new JLabel("ID");
        ID.setFont(new Font("Serif", Font.PLAIN, 15));
        ID.setSize(100, 20);
        ID.setLocation(100, 450);
        kontenitori.add(ID);


        kartaID = new JTextField();
        kartaID.setFont(new Font("Serif", Font.PLAIN, 15));
        kartaID.setSize(100, 20);
        kartaID.setLocation(200, 450);
        kartaID.write(fileWriter);
        kontenitori.add(kartaID);
 
        
        term = new JCheckBox("Klikoni per te pranuar rregulloren tone. ");
        term.setFont(new Font("Serif", Font.BOLD, 10));
        term.setSize(250, 20);
        term.setLocation(150, 500);
        kontenitori.add(term);
 
        sub = new JButton("Derzo");
        sub.setFont(new Font("Serif", Font.PLAIN, 17));
        sub.setSize(100, 20);
        sub.setLocation(150, 550);
        sub.addActionListener(this);
        sub.setBackground(new Color (72,209,204));      //ne mac nuk vendoset direkt setbackground(Color.color)
       
        sub.setOpaque(true);                         // to display background color we need this line of code
        sub.setBorderPainted(false);
        kontenitori.add(sub);
 
        reset = new JButton("Rinis");
        reset.setFont(new Font("Serif", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(270, 550);
        reset.addActionListener(this); // makes it usable by user
        reset.setBackground(new Color(240,128,128));
        reset.setOpaque(true);
        reset.setBorderPainted(false);
        kontenitori.add(reset);


        // ktu ndrysho
 
        teksti_i_dale = new JTextArea();
        teksti_i_dale.setFont(new Font("Serif", Font.PLAIN, 15));
        teksti_i_dale.setSize(500 ,150 );
        teksti_i_dale.setLocation(50, 650);
        teksti_i_dale.setLineWrap(true);
        teksti_i_dale.setEditable(false);
        kontenitori.add(teksti_i_dale);
 
        rregjistrimiISuk = new JLabel();
        rregjistrimiISuk.setFont(new Font("Serif", Font.PLAIN, 20));
        rregjistrimiISuk.setSize(500,20);
        rregjistrimiISuk.setLocation(100, 600);
        kontenitori.add(rregjistrimiISuk);



        rregjistrimiReset = new JTextArea(); 
        rregjistrimiReset.setFont(new Font("Serif", Font.PLAIN, 15));
        rregjistrimiReset.setSize(500, 20);
        rregjistrimiReset.setLocation(50, 600);
        rregjistrimiReset.setLineWrap(false);
        kontenitori.add(rregjistrimiReset);
 
        setVisible(true); //ben cdo gje visable ne frame
    }


    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == sub) {  //printon aksionet e performuara  in buttons from user 
            
           

            if (term.isSelected()) {
                String data1;
                String data
                    = "Emri : "
                      + textEmri.getText() 
                      + "  Mbiemri : " + textMbimri.getText()  
                      + "  Karta ID : " 
                      + kartaID.getText() + "\n";
                if (mashkull.isSelected())
                    data1 = "Gjinia : Mashkull"
                            + "\n";
                else
                    data1 = "Gjinia : Femer"
                            + "\n";
                String data2
                    = "Ditelindja : "
                      + (String)datat_e_muajit.getSelectedItem()
                      + "/" + (String)muajt.getSelectedItem()
                      + "/" + (String)viti.getSelectedItem()
                      + "\n";
 
                String data3 = "Adresa : " + adresaAdd.getText();
                teksti_i_dale.setText(data + data1 + data2 + data3);
                teksti_i_dale.setEditable(false);


                // nqs aplikanti eshte mashkull/femer
                if (mashkull.isSelected())
                rregjistrimiISuk.setText("Rregjistrimi sukses!Vazhdoni ne menu Z." + textMbimri.getText());

                else
                rregjistrimiISuk.setText("Rregjistrimi sukses!Vazhdoni ne menu Znj." + textMbimri.getText());

             

                 
            }
            else {
                teksti_i_dale.setText("");
                rregjistrimiReset.setText("");
                rregjistrimiISuk.setText("Plotesoni te gjitha te dhenat/"
                            + "klikoni ne rregulloren ");
            }
        }
 
        else if (e.getSource() == reset) {
            String def = "";
            textEmri.setText(def);
            adresaAdd.setText(def);
            kartaID.setText(def);
            rregjistrimiISuk.setText(def);
            teksti_i_dale.setText(def);
            term.setSelected(false);
            datat_e_muajit.setSelectedIndex(0);
            muajt.setSelectedIndex(0);
            viti.setSelectedIndex(0);
            rregjistrimiReset.setText(def);
        }
    }
    }


   
    
       


             
         
          
    
