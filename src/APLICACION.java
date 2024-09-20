import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class APLICACION extends JApplet implements ActionListener {
	
	JScrollPane scpReporte;
	JTextArea txtReporte;
	JButton btnIngresar,btnVolver,btnRegistrar,btnPostergar,btnCancelar,btnLimpiar;
	JPasswordField txtPassword;
	JComboBox cboOrigen,cboDestino,cboAereopuerto;
	JTextField txtUser,txtFechaCompraD,txtFechaCompraM,txtFechaCompraA,txtFechaSalidaD,txtFechaSalidaM,txtFechaSalidaA;
	JTextField txtCantPer,txtHorSalid,txtMinSalid,txtPrecio;
	JLabel lblFondo,lblFondo2,lblUser,lblPassword,lblFechaCompra,lblFechaSalida,lblOrigen,lblDestino,lblAereopuerto;
	JLabel lblCategoria,lbl1;
	JPanel pnlIngreso,pnlDatos;
	
	String user,contra,aeropst,orgst,destinost,MR,CR,DR,UR,numRomano,numletras,lu,ld,lc,lum,fechaNueva,montoletras,luc,ldc,lcc,lumc;
	int precio,cantper,aerop,org,destino,diaCompra,mesCompra,añoCompra,diaVuelo,mesVuelo,añoVuelo,horaVuelo,minVuelo,edad,diaActual,mesActual,añoActual;
	int M,C,D,U,opPoster,cc,cpo,MC,CC,DC,UC;
	double importeFinal=0.0;
	double importePersonal=0.0;
	double dscto=0.0;
	double importeDolar,importeEuro,penaliz,montoDev;
	
	Font CourierNew=new Font("Liberation Mono",1,11);
	Font CourierNew2=new Font("Liberation Mono",1,11);
	Font Calibri=new Font("Calibri",0,16);
	Font Arial=new Font("Arial",0,13);
	Font Arial2=new Font("Arial",1,8);
	Font ComicSans=new Font("Comic Sans MS",1,18);
	
	Color blanco=new Color(255,255,255);
	Color negro=new Color(0,0,0);
	Color plomo=new Color(111,120,132);
	Color Rojo=new Color(224,46,32);
	Color txtletra=new Color(252,223,171);
	
	public void init() {	

	login();
	datos();
}

	public void login(){
		
//__________ *PANEL PARA LA IMAGEN DE FONDO*__________		
		pnlIngreso=new JPanel();
		pnlIngreso.setLayout(null);
		pnlIngreso.setBounds(0,0,1080,720);
		add(pnlIngreso);
		setSize(1080,720);
		
//____________*JLABEL Y JTEXTFIELD PARA USUARIO Y CONTRASEÑA*_________		
		lblUser=new JLabel("USUARIO:");
		lblUser.setBounds(515, 310, 100, 50);
		lblUser.setFont(CourierNew);
		lblUser.setForeground(blanco);
		pnlIngreso.add(lblUser);
		
		txtUser=new JTextField();
		txtUser.setBounds(488,350,104,20);
		txtUser.setFont(CourierNew);
		txtUser.setForeground(negro);
		pnlIngreso.add(txtUser);
		
		lblPassword=new JLabel("CONTRASEÑA:");
		lblPassword.setBounds(502, 368, 150, 50);
		lblPassword.setFont(CourierNew);
		lblPassword.setForeground(blanco);
		pnlIngreso.add(lblPassword);
		
		txtPassword=new JPasswordField();
		txtPassword.setBounds(488,410,104,20);
		txtPassword.setFont(CourierNew2);
		txtPassword.setForeground(negro);
		pnlIngreso.add(txtPassword);
//___________*BOTON PARA LOGEARSE*_______________________		
		btnIngresar= new JButton("INGRESAR");
        btnIngresar.setBounds(495,457,89,20);
        btnIngresar.addActionListener(this);
        btnIngresar.setFont(CourierNew);
		btnIngresar.setForeground(plomo);
		btnIngresar.setBackground(blanco);
        pnlIngreso.add(btnIngresar);
		
		
//___________*IMAGEN DE FONDO*_________________________		
		
		lblFondo=new JLabel("");
		lblFondo.setBounds(0,0,1080,720);
		lblFondo.setIcon(new ImageIcon("fondo.png"));
		pnlIngreso.add(lblFondo);

//______________________________________________________
	}
	
	public void datos(){
			
//__________ *PANEL PARA LA SEGUNDA IMAGEN DE FONDO*__________			
		pnlDatos=new JPanel();
		pnlDatos.setLayout(null);
		pnlDatos.setVisible(false);
		pnlDatos.setBounds(0,0,1080,720);
		add(pnlDatos);
		setSize(1080,720);

//____________*JLABEL Y JTEXTFIELD PARA REGISTRO DE VENTAS*_________		
		
		lblFechaCompra=new JLabel("Fecha de Compra:");
		lblFechaCompra.setBounds(40, 290, 120, 55);
		lblFechaCompra.setFont(Calibri);
		lblFechaCompra.setForeground(negro);
		pnlDatos.add(lblFechaCompra);

		txtFechaCompraD=new JTextField();
		txtFechaCompraD.setBounds(170,308,30,20);
		txtFechaCompraD.setFont(Arial);
		txtFechaCompraD.setForeground(negro);
		pnlDatos.add(txtFechaCompraD);
		
		lbl1=new JLabel("/");
		lbl1.setBounds(205, 308, 20, 20);
		lbl1.setFont(Calibri);
		lbl1.setForeground(negro);
		pnlDatos.add(lbl1);
		
		txtFechaCompraM=new JTextField();
		txtFechaCompraM.setBounds(220,308,30,20);
		txtFechaCompraM.setFont(Arial);
		txtFechaCompraM.setForeground(negro);
		pnlDatos.add(txtFechaCompraM);
		
		lbl1=new JLabel("/");
		lbl1.setBounds(255, 308, 20, 20);
		lbl1.setFont(Calibri);
		lbl1.setForeground(negro);
		pnlDatos.add(lbl1);
		
		txtFechaCompraA=new JTextField();
		txtFechaCompraA.setBounds(270,308,40,20);
		txtFechaCompraA.setFont(Arial);
		txtFechaCompraA.setForeground(negro);
		pnlDatos.add(txtFechaCompraA);

		lblFechaSalida=new JLabel("Fecha de Salida:");
		lblFechaSalida.setBounds(40, 340, 120, 55);
		lblFechaSalida.setFont(Calibri);
		lblFechaSalida.setForeground(negro);
		pnlDatos.add(lblFechaSalida);

		txtFechaSalidaD=new JTextField();
		txtFechaSalidaD.setBounds(170,358,30,20);
		txtFechaSalidaD.setFont(Arial);
		txtFechaSalidaD.setForeground(negro);
		pnlDatos.add(txtFechaSalidaD);
		
		lbl1=new JLabel("/");
		lbl1.setBounds(205, 358, 20, 20);
		lbl1.setFont(Calibri);
		lbl1.setForeground(negro);
		pnlDatos.add(lbl1);
		
		txtFechaSalidaM=new JTextField();
		txtFechaSalidaM.setBounds(220,358,30,20);
		txtFechaSalidaM.setFont(Arial);
		txtFechaSalidaM.setForeground(negro);
		pnlDatos.add(txtFechaSalidaM);
		
		lbl1=new JLabel("/");
		lbl1.setBounds(255, 358, 20, 20);
		lbl1.setFont(Calibri);
		lbl1.setForeground(negro);
		pnlDatos.add(lbl1);
		
		txtFechaSalidaA=new JTextField();
		txtFechaSalidaA.setBounds(270,358,40,20);
		txtFechaSalidaA.setFont(Arial);
		txtFechaSalidaA.setForeground(negro);
		pnlDatos.add(txtFechaSalidaA);
		
		lbl1 = new JLabel("Hora de Salida: ");
		lbl1.setBounds(40,390,120,55);
		lbl1.setFont(Arial);
		lbl1.setForeground(negro);
		pnlDatos.add(lbl1);
		
		txtHorSalid = new JTextField();
		txtHorSalid.setBounds(170,408,30,20);
		txtHorSalid.setFont(Arial);
		txtHorSalid.setForeground(negro);
		pnlDatos.add(txtHorSalid);
		
		lbl1 = new JLabel(":");
		lbl1.setBounds(210,408,30,20);
		lbl1.setFont(Arial);
		lbl1.setForeground(negro);
		pnlDatos.add(lbl1);
		
		txtMinSalid = new JTextField();
		txtMinSalid.setBounds(220,408,30,20);
		txtMinSalid.setFont(Arial);
		txtMinSalid.setForeground(negro);
		pnlDatos.add(txtMinSalid);
	
//____________*COMBOBOX PARA REGISTRO DE VENTAS*_________	
      
		lblOrigen=new JLabel("Origen:");
		lblOrigen.setBounds(330, 330, 120, 55);
		lblOrigen.setFont(Calibri);
		lblOrigen.setForeground(negro);
		pnlDatos.add(lblOrigen);
		
		cboOrigen=new JComboBox();
		cboOrigen.addItem("Lima     ");
		cboOrigen.setBounds(390, 347, 100, 20);
		cboOrigen.setFont(Arial);
		pnlDatos.add(cboOrigen);

	    lblDestino=new JLabel("Destino:");
		lblDestino.setBounds(330, 390, 120, 55);
		lblDestino.setFont(Calibri);
		lblDestino.setForeground(negro);
		pnlDatos.add(lblDestino);
		
		cboDestino=new JComboBox();
		cboDestino.addItem("Seleccione:");
		cboDestino.addItem("1. España");
		cboDestino.addItem("2. Italia");
		cboDestino.addItem("3. Francia");
		cboDestino.setFont(Arial);
		cboDestino.setBounds(390, 407, 100, 20);
		pnlDatos.add(cboDestino);
		
	    lblAereopuerto=new JLabel("Aereopuerto:");
		lblAereopuerto.setBounds(330, 270, 120, 55);
		lblAereopuerto.setFont(Calibri);
		lblAereopuerto.setForeground(negro);
		pnlDatos.add(lblAereopuerto);				

		cboAereopuerto=new JComboBox();
		cboAereopuerto.addItem("Seleccione:");
		cboAereopuerto.addItem("Intl. Jorge Chavez");
		cboAereopuerto.setFont(Arial);
		cboAereopuerto.setBounds(420, 287, 140, 20);
		pnlDatos.add(cboAereopuerto);
		
//____________*JLABEL Y JTEXTFIELD PARA REGISTRO DE VENTAS*_________		
		
		lbl1 =new JLabel("Cantidad de Personas:");
		lbl1.setBounds(600,270,150,55);
		lbl1.setFont(Arial);
		lbl1.setForeground(negro);
		pnlDatos.add(lbl1);
		
		txtCantPer = new JTextField();
		txtCantPer.setBounds(750,285,120,30);
		txtCantPer.setFont(Arial);
		txtCantPer.setForeground(negro);
		pnlDatos.add(txtCantPer);
		
		lbl1 =new JLabel("Precio del Boleto:");
		lbl1.setBounds(600,320,150,55);
		lbl1.setFont(Arial);
		lbl1.setForeground(negro);
		pnlDatos.add(lbl1);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(750,335,120,30);
		txtPrecio.setFont(Arial);
		txtPrecio.setForeground(negro);
		pnlDatos.add(txtPrecio);
		
		btnRegistrar= new JButton("Registrar");
        btnRegistrar.setBounds(780, 420, 100, 25);
        btnRegistrar.addActionListener(this);
        btnRegistrar.setForeground(blanco);
		btnRegistrar.setBackground(Rojo);
        pnlDatos.add(btnRegistrar);
        
        btnPostergar = new JButton("Postergar");
        btnPostergar.setBounds(890, 420, 100, 25);
        btnPostergar.addActionListener(this);
        btnPostergar.setForeground(blanco);
		btnPostergar.setBackground(Rojo);
        pnlDatos.add(btnPostergar);
        
        btnVolver = new JButton("Volver");
        btnVolver.setBounds(1000, 30, 60, 20);
        btnVolver.addActionListener(this);
        btnVolver.setForeground(blanco);
		btnVolver.setBackground(Rojo);
		btnVolver.setFont(Arial2);
        pnlDatos.add(btnVolver);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(670, 420, 100, 25);
        btnCancelar.addActionListener(this);
        btnCancelar.setForeground(blanco);
		btnCancelar.setBackground(Rojo);
        pnlDatos.add(btnCancelar);
        
        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(560, 420, 100, 25);
        btnLimpiar.addActionListener(this);
        btnLimpiar.setForeground(blanco);
		btnLimpiar.setBackground(Rojo);
        pnlDatos.add(btnLimpiar);
        
        txtReporte=new JTextArea();
        txtReporte.setEditable(false);
        txtReporte.setFont(ComicSans);
        scpReporte=new JScrollPane(txtReporte);
        scpReporte.setBounds(28,488,1025,215);
        pnlDatos.add(scpReporte);
        
		
		
//___________*IMAGEN DE FONDO*_________________________	

		lblFondo2=new JLabel("");
		lblFondo2.setBounds(0,0,1080,720);
		lblFondo2.setIcon(new ImageIcon("ventas.png"));
		pnlDatos.add(lblFondo2);


//______________________________________________________	
	
}

	public void actionPerformed( ActionEvent e ){
//_______________________	
	contra=txtPassword.getText();
		user=txtUser.getText();
		 if (e.getSource()==btnIngresar){
		 	 if ((contra.equals("aerlinelan"))&&(user.equals("admin"))){
	    		Ingreso();
				}
			else{
				JOptionPane.showMessageDialog(null,"Usuario y/o Contraseña incorrectos");
				txtUser.setText("");
				txtPassword.setText("");
				}
			}
	 	if (e.getSource()==btnVolver)
	  	  Volver();
	  	if (e.getSource()==btnRegistrar){
	  		LecturaDatos();
	  		CalculoImporte();
	  		DescompNum();
	  		NumLetras();
	  		NumRomanos();
	  		ImporteDolEu();
	  		Registro();
	  	}
	  	if (e.getSource()==btnPostergar){
	  		FechaActual();
	  		ConfirFechaPost();
	  		ReportePost();
	  	}
	  	if (e.getSource()==btnCancelar){
	  		FechaActual();
	  		ConfirFechaCancel();
	  		DevNumLetras();
	  		ReporteCancel();
	  	}
	  	if (e.getSource()==btnLimpiar)
	  		Limpiar();
	}
	
//_______________________	
	public void Ingreso(){
		pnlIngreso.setVisible(false);
		pnlDatos.setVisible(true);
	}
//_______________________		
	public void Volver(){
		pnlIngreso.setVisible(true);
		pnlDatos.setVisible(false);			
	}
//_______________________	
	public void LecturaDatos(){
		precio=Integer.parseInt(txtPrecio.getText());
		cantper=Integer.parseInt(txtCantPer.getText());
		aerop=cboAereopuerto.getSelectedIndex();
		switch(aerop){
		case 1: aeropst="Aeropuerto Internacional Jorge Chávez";break;}
		org=cboOrigen.getSelectedIndex();
		switch(org){
		case 0: orgst="Lima";break;}
		destino=cboDestino.getSelectedIndex();
		switch(destino){
		case 1: destinost="España";break;
		case 2: destinost="Italia";break;
		case 3: destinost="Francia";break;
		default: destinost="Seleccione un destino";break;}
		diaCompra=Integer.parseInt(txtFechaCompraD.getText());
		mesCompra=Integer.parseInt(txtFechaCompraM.getText());
		añoCompra=Integer.parseInt(txtFechaCompraA.getText());
		diaVuelo=Integer.parseInt(txtFechaSalidaD.getText());
		mesVuelo=Integer.parseInt(txtFechaSalidaM.getText());
		añoVuelo=Integer.parseInt(txtFechaCompraA.getText());
		horaVuelo=Integer.parseInt(txtHorSalid.getText());
		minVuelo=Integer.parseInt(txtMinSalid.getText());
	}
	public void CalculoImporte(){
		int i=1;
		if(cantper == 2){
				dscto = 0.15;
		}
		else {
			if(cantper == 3){
				dscto=0.20;
			}
			else {
				if(cantper >=4 && cantper <=10){
					dscto = 0.25;
				}
				else {
					if(cantper > 10){
						dscto = 0.41;
					}
				}
			}
		}
		
		while (i<=cantper){
			edad=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la edad del pasajero "+i));
			if (edad<=2){
				importePersonal=precio*0.2;
			}
			else{
				if(edad<=10){
					importePersonal=precio*0.8;
				}
				else{
					if(edad>70){
						importePersonal=precio*0.59;
					}
					else
						importePersonal=100;
				}
			}
			importeFinal=importeFinal+importePersonal;
			i=i+1;
		}
		importeFinal=importeFinal-importeFinal*dscto;
	}
	public void DescompNum(){
		M=(int)(importeFinal/1000);
		C=(int)((importeFinal % 1000)/100);
		D=(int)(((importeFinal % 1000) % 100)/10);
		U=(int)(((importeFinal % 1000) % 100) % 10);
	}
	public void NumLetras(){
		switch (U){
			case 1: lu="uno";break;
			case 2: lu="dos";break;
			case 3: lu="tres";break;
			case 4: lu="cuatro";break;
			case 5: lu="cinco";break;
			case 6: lu="seis";break;
			case 7: lu="siete";break;
			case 8: lu="ocho";break;
			case 9: lu="nueve";break;
			default: lu="";break;
			}
		switch (D){
			case 1: switch (U){
							case 0: ld="diez";break;
							case 1: ld="once";break;
							case 2: ld="doce";break;
							case 3: ld="trece";break;
							case 4: ld="catorce";break;
							case 5: ld="quince";break;
							case 6: ld="dieciseis";break;
							case 7: ld="diecisiete";break;
							case 8: ld="dieciocho";break;
							case 9: ld="diecinueve";break;
							}
			case 2: if (U==0)
							ld="veinte";
						else
							ld="veinti"+lu;break;
			case 3: if (U==0)
							ld="treinta";
						else
							ld="treinta y "+lu;break;
			case 4: if (U==0)
							ld="cuarenta";
						else
							ld="cuarenta y "+lu;break;
			case 5: if (U==0)
							ld="cincuenta";
						else
							ld="cincuenta y "+lu;break;
			case 6: if (U==0)
							ld="sesenta";
						else
							ld="sesenta y "+lu;break;
			case 7: if (U==0)
							ld="setenta";
						else
							ld="setenta y "+lu;break;
			case 8: if (U==0)
							ld="ochenta";
						else
							ld="ochenta y "+lu;break;
			case 9: if (U==0)
							ld="noventa";
						else
							ld="noventa y "+lu;break;
			default: ld=""+lu;break;
			}
		switch (C){
			case 1: if (D==0 && U==0)
							lc="cien";
						else
							lc="ciento ";break;
			case 2: lc="doscientos ";break;
			case 3: lc="trescientos ";break;
			case 4: lc="cuatrocientos ";break;
			case 5: lc="quinientos ";break;
			case 6: lc="seiscientos ";break;
			case 7: lc="setecientos ";break;
			case 8: lc="ochocientos ";break;
			case 9: lc="novecientos ";break;
			default: lc="";break;
			}	
		switch (M){
			case 1: lum="mil ";break;
			case 2: lum="dos mil ";break;
			case 3: lum="tres mil ";break;
			case 4: lum="cuatro mil ";break;
			case 5: lum="cinco mil ";break;
			case 6: lum="seis mil ";break;
			case 7: lum="siete mil ";break;
			case 8: lum="ocho mil ";break;
			case 9: lum="nueve mil ";break;
			default: lum="";break;
			}
		numletras=lum+lc+ld;
	}
	public void NumRomanos(){
	
	MR=null;
	CR=null;
	DR=null;
	UR=null;
	
		if (M==0)
			MR="";
		if (M==1)
			MR="M";
		if (M==2)
			MR="MM";
		if (M==3)
			MR="MMM";
		if (C==0)
			CR="";
		if (C==1)
			CR="C";
		if (C==2)
			CR="CC";
		if (C==3)
			CR="CC";
		if (C==4)
			CR="CD";
		if (C==5)
			CR="D";
		if (C==6)
			CR="DC";
		if (C==7)
			CR="DCC";
		if (C==8)
			CR="DCCC";
		if (C==9)
			CR="CM";
		if (D==0)
			DR="";
		if (D==1)
			DR="X";
		if (D==2)
			DR="XX";
		if (D==3)
			DR="XXX";
		if (D==4)
			DR="XL";
		if (D==5)
			DR="L";
		if (D==6)
			DR="LX";
		if (D==7)
			DR="LX";
		if (D==8)
			DR="LXXX";
		if (D==9)
			DR="XC";	
		if (U==0)
			UR="";
		if (U==1)
			UR="I";
		if (U==2)
			UR="II";
		if (U==3)
			UR="III";
		if (U==4)
			UR="IV";
		if (U==5)
			UR="V";
		if (U==6)
			UR="VI";
		if (U==7)
			UR="VII";
		if (U==8)
			UR="VIII";
		if (U==9)
			UR="IX";
		numRomano=MR+CR+DR+UR;
	}
	public void ImporteDolEu(){
		importeDolar=importeFinal*0.27;
		importeEuro=importeFinal*0.25;
	}
	public void Registro(){
		txtReporte.setText("------------------------------------------------------------------ \n");
		txtReporte.append("REPORTE DE PASAJE \n");
		txtReporte.append("Fecha de la Compra: "+diaCompra+"/"+mesCompra+"/"+añoCompra+"\n");
		txtReporte.append("Fecha del Vuelo: "+diaVuelo+"/"+mesVuelo+"/"+añoVuelo+"\n");
		txtReporte.append("Hora de Salida del Vuelo: "+horaVuelo+":"+minVuelo+"\n");
		txtReporte.append("Aeropuerto de Embarque: "+aeropst+"\n");
		txtReporte.append("Origen del Vuelo: "+orgst+"\n");
		txtReporte.append("Destino del Vuelo: "+destinost+"\n");
		txtReporte.append("Cantidad de Personas: "+cantper+"\n");
		txtReporte.append("Precio del Boleto: "+precio+"\n");
		txtReporte.append("Importe Final en Soles: S/."+importeFinal+"\n");
		txtReporte.append("Se lee: "+numletras+"\n");
		txtReporte.append("Importe Final en Dolares: $."+importeDolar+"\n");
		txtReporte.append("Importe Final en Euros: €."+importeEuro+"\n");
		if(destino==2)
			txtReporte.append("Importe Final en Romanos: "+numRomano+"\n");
		txtReporte.append("------------------------------------------------------------------ \n");
	}
	public void FechaActual(){
		diaActual=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el día actual:"));
		mesActual=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el mes actual:"));
		añoActual=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el año actual:"));
	}
	public void ConfirFechaPost(){
		if((añoActual==añoVuelo) && (mesActual==mesVuelo) && (diaVuelo-2>=diaActual)){
			opPoster=Integer.parseInt(JOptionPane.showInputDialog(null,"Desea: 1. Solicitar nueva fecha - 2. Dejarla pendiente"));
			switch(opPoster){
			case 1: fechaNueva=JOptionPane.showInputDialog(null,"Ingrese la nueva fecha de viaje:");cpo=1;break;
			case 2: JOptionPane.showMessageDialog(null,"Su fecha de viaje queda pendiente. Plazo maximo 1 año");
						fechaNueva="Pendiente";cpo=1;break;
			default: JOptionPane.showMessageDialog(null,"ERROR: Digite el número correspondiente a una opcion");cpo=0;break;
			}
		}
		else{
			if( (añoActual==añoVuelo) && (mesVuelo-1==mesActual) && (diaVuelo<3) && (diaActual<32)){
				opPoster=Integer.parseInt(JOptionPane.showInputDialog(null,"Desea: 1. Solicitar nueva fecha - 2. Dejarla pendiente"));
				switch(opPoster){
				case 1: fechaNueva=JOptionPane.showInputDialog(null,"Ingrese la nueva fecha de viaje:");cpo=1;break;
				case 2: JOptionPane.showMessageDialog(null,"Su fecha de viaje queda pendiente. Plazo maximo 1 año");
						fechaNueva="Pendiente";cpo=1;break;
				default: JOptionPane.showMessageDialog(null,"ERROR: Digite el número correspondiente a una opcion");cpo=0;break;
				}
			}
			else{
				if((añoVuelo-1==añoActual) && (mesVuelo==1 && mesActual==12) && (diaVuelo<3) && (diaActual<31)){
					opPoster=Integer.parseInt(JOptionPane.showInputDialog(null,"Desea: 1. Solicitar nueva fecha - 2. Dejarla pendiente"));
					switch(opPoster){
					case 1: fechaNueva=JOptionPane.showInputDialog(null,"Ingrese la nueva fecha de viaje:");cpo=1;break;
					case 2: JOptionPane.showMessageDialog(null,"Su fecha de viaje queda pendiente. Plazo maximo 1 año");
								fechaNueva="Pendiente";cpo=1;break;
					default: JOptionPane.showMessageDialog(null,"ERROR: Digite el número correspondiente a una opcion");cpo=0;break;
					}
				}
				else{
					JOptionPane.showMessageDialog(null,"Fuera de tiempo");cpo=0;
				}
			}
		}
	}
	public void ReportePost(){
		if(cpo==1){
		txtReporte.setText("------------------------------------------------------------------ \n");
		txtReporte.append("REPORTE DE POSTERGADO \n");
		txtReporte.append("Fecha de la Compra: "+diaCompra+"/"+mesCompra+"/"+añoCompra+"\n");
		txtReporte.append("Fecha del Vuelo: "+fechaNueva+"\n");
		txtReporte.append("Aeropuerto de Embarque: "+aeropst+"\n");
		txtReporte.append("Origen del Vuelo: "+orgst+"\n");
		txtReporte.append("Destino del Vuelo: "+destinost+"\n");
		txtReporte.append("Cantidad de Personas: "+cantper+"\n");
		txtReporte.append("Precio del Boleto: "+precio+"\n");
		txtReporte.append("Importe Final en Soles: S/."+importeFinal+"\n");
		txtReporte.append("Se lee: "+numletras+"\n");
		txtReporte.append("Importe Final en Dolares: $."+importeDolar+"\n");
		txtReporte.append("Importe Final en Euros: €."+importeEuro+"\n");
		if(destino==2)
			txtReporte.append("Importe Final en Romanos: "+numRomano+"\n");
		txtReporte.append("------------------------------------------------------------------ \n");
		}
	}
	public void ConfirFechaCancel(){
		if((añoActual==añoVuelo) && (mesActual==mesVuelo) && (diaVuelo-2>=diaActual)){
			JOptionPane.showMessageDialog(null,"Viaje cancelado con éxito. Generando voucher de cancelación ");cc=1;
			}
		else{
			if( (añoActual==añoVuelo) && (mesVuelo-1==mesActual) && (diaVuelo<3) && (diaActual<32)){
				JOptionPane.showMessageDialog(null,"Viaje cancelado con éxito. Generando voucher de cancelación ");cc=1;
				}
			else{
				if((añoVuelo-1==añoActual) && (mesVuelo==1 && mesActual==12) && (diaVuelo<3) && (diaActual<31)){
					JOptionPane.showMessageDialog(null,"Viaje cancelado con éxito. Generando voucher de cancelación ");cc=1;
					}
				else{
					JOptionPane.showMessageDialog(null,"Fuera de tiempo");cc=0;
				}
			}
		}
	}
	public void ReporteCancel(){
		if(cc==1){
			txtReporte.setText("------------------------------------------------------------------ \n");
			txtReporte.append("VOUCHER DE CANCELACIÓN \n");
			txtReporte.append("Importe de Compra: "+importeFinal+"\n");
			txtReporte.append("Descuento por Penalización: "+penaliz+"\n");
			txtReporte.append("Monto Devuelto: "+montoDev+"\n");
			txtReporte.append("Se lee: "+montoletras+"\n");
			txtReporte.append("------------------------------------------------------------------ \n");
		}
	}
	public void DevNumLetras(){
		penaliz=importeFinal*0.15;
		montoDev=importeFinal-penaliz;
		MC=(int)(montoDev/1000);
		CC=(int)((montoDev % 1000)/100);
		DC=(int)(((montoDev % 1000) % 100)/10);
		UC=(int)(((montoDev % 1000) % 100) % 10);
		switch (UC){
			case 1: luc="uno";break;
			case 2: luc="dos";break;
			case 3: luc="tres";break;
			case 4: luc="cuatro";break;
			case 5: luc="cinco";break;
			case 6: luc="seis";break;
			case 7: luc="siete";break;
			case 8: luc="ocho";break;
			case 9: luc="nueve";break;
			default: luc="";break;
			}
		switch (DC){
			case 1: switch (UC){
							case 0: ldc="diez";break;
							case 1: ldc="once";break;
							case 2: ldc="doce";break;
							case 3: ldc="trece";break;
							case 4: ldc="catorce";break;
							case 5: ldc="quince";break;
							case 6: ldc="dieciseis";break;
							case 7: ldc="diecisiete";break;
							case 8: ldc="dieciocho";break;
							case 9: ldc="diecinueve";break;
							}
			case 2: if (UC==0)
							ldc="veinte";
						else
							ldc="veinti"+luc;break;
			case 3: if (UC==0)
							ldc="treinta";
						else
							ldc="treinta y "+luc;break;
			case 4: if (UC==0)
							ldc="cuarenta";
						else
							ldc="cuarenta y "+luc;break;
			case 5: if (UC==0)
							ldc="cincuenta";
						else
							ldc="cincuenta y "+luc;break;
			case 6: if (UC==0)
							ldc="sesenta";
						else
							ldc="sesenta y "+luc;break;
			case 7: if (UC==0)
							ldc="setenta";
						else
							ldc="setenta y "+luc;break;
			case 8: if (UC==0)
							ldc="ochenta";
						else
							ldc="ochenta y "+luc;break;
			case 9: if (UC==0)
							ldc="noventa";
						else
							ldc="noventa y "+luc;break;
			default: ldc=""+luc;break;
			}
		switch (CC){
			case 1: if (DC==0 && UC==0)
							lcc="cien";
						else
							lcc="ciento ";break;
			case 2: lcc="doscientos ";break;
			case 3: lcc="trescientos ";break;
			case 4: lcc="cuatrocientos ";break;
			case 5: lcc="quinientos ";break;
			case 6: lcc="seiscientos ";break;
			case 7: lcc="setecientos ";break;
			case 8: lcc="ochocientos ";break;
			case 9: lcc="novecientos ";break;
			default: lcc="";break;
			}	
		switch (MC){
			case 1: lumc="mil ";break;
			case 2: lumc="dos mil ";break;
			case 3: lumc="tres mil ";break;
			case 4: lumc="cuatro mil ";break;
			case 5: lumc="cinco mil ";break;
			case 6: lumc="seis mil ";break;
			case 7: lumc="siete mil ";break;
			case 8: lumc="ocho mil ";break;
			case 9: lumc="nueve mil ";break;
			default: lumc="";break;
			}
		montoletras=lumc+lcc+ldc;
	}
	public void Limpiar(){
		txtReporte.setText("");
		txtCantPer.setText("");
		txtHorSalid.setText("");
		txtMinSalid.setText("");
		txtPrecio.setText("");
		txtFechaCompraD.setText("");
		txtFechaCompraM.setText("");
		txtFechaCompraA.setText("");
		txtFechaSalidaD.setText("");
		txtFechaSalidaM.setText("");
		txtFechaSalidaA.setText("");
	}
}
