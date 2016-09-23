import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
 
public class version1 {
     static ArrayList<String> data = new ArrayList<String>();
    static StringBuffer output = new StringBuffer();
    static int pairsToRead;
    static StringBuffer message = new StringBuffer();
    static StringBuffer tempvar = new StringBuffer();
    static int temp;
    static String tempString;
    static int bin;
   
    public static void main(String[] args) throws IOException {
        
       byte[] bin;
       Scanner scanner = new Scanner(System.in); 
         int temp3=0;
         int count;
         StringBuilder sb = new StringBuilder();
         StringBuilder s3=new StringBuilder();
          version1 binary = new version1();
         
        
          System.out.print("Ingresa el nombre del archivo de apertura con extension:\n");  
          String archivoapertura = scanner.next(); 
          String FILE_NAME = archivoapertura;
          System.out.print("Ingresa el nombre del archivo destino con extension:\n");  
          String archivoagrabar = scanner.next(); 
           byte[] bytes = binary.readSmallBinaryFile(FILE_NAME);
          
            String src2=new String();
     
          for(byte b:bytes)
                        {
                            s3.append(String.format("%02X",b));
                        }
          for(String part:getParts(s3.toString(),2))
                        {
                            //string full almacena el par actual
                            String full=part;
                            data.add(full);//imprime pares bandera decimal
                        }
        // System.out.println("tamanio de hex\n"+s3.length());
         int totalpares=s3.length()/2;
         //System.out.println("pares totales:\n"+totalpares);
                        //ciclo para divir en pares
        
           // System.out.println("impresion del archivo en hex\n"+s3.toString());
        
         /*for(int e=14;e<data.size();e++)
         {
            System.out.println("par: " +e+ " el par es :" +data.get(e));
            }*/
            int d=14;
            String temp1;
            message.append("(C)CHUNKUN\n");
            int tempsum=0;
            int x=0;
         while(d<data.size())
            {
                temp1=data.get(d);
                //System.out.println(temp1);
                //la bandera de arriba se usa para saber a que case esta entrando el programa
                switch(temp1){
                                case "00":
                                 message.append("HALT");
                                message.append("\n");
                                d=d+1;
                                //write to file "HALT"
                                    break;
                                case "01":
                                //write to file "PRTCR"
                                 message.append("prtcr");
                                d=d+1;
                                message.append("\n");
                                    break;
                                case "02":
                                //write to file "PRTC"
                                String call02;
                                call02=content(3,d,data);
                                message.append("prtc  var_"+call02);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "03":
                                //write to file "PRTI"
                                String call1;
                                call1=content(3,d,data);
                                message.append("prti  var_"+call1);
                                d=d+3;
                                message.append("\n");
                                   break;
                                case "04":
                                //write to file "PRTF"
                                String call04;
                                call04=content(3,d,data);
                                message.append("prtf  var_"+call04);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "05":
                                //write to file "PRTD"
                                String call05;
                                call05=content(3,d,data);
                                message.append("prtd  var_"+call05);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "06":
                                //write to file "PRTS"
                                String call2;
                                call2=content(3,d,data);
                                message.append("prts  var_"+call2);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "07":
                                //write to file "PRTAC"
                                String call07;
                                call07=content(3,d,data);
                                message.append("prtac  array_"+call07);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "08":
                               //write to file "PRTAI"
                                 String call8;
                                call8=content(3,d,data);
                                message.append("prtai  array_"+call8);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "09":
                                //write to file "PRTAF"
                                String call09;
                                call09=content(3,d,data);
                                message.append("prtaf  array_"+call09);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "0A":
                                //write to file "PRTAD"
                                String call0a;
                                call0a=content(3,d,data);
                                message.append("prtad  array_"+call0a);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "0B":
                               //write to file "PRTAS"
                                String call0b;
                                call0b=content(3,d,data);
                                message.append("prtas  array_"+call0b);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "0C":
                                //write to file "PUSHC"
                                 String call0c;
                                call0c=content(3,d,data);
                                message.append("pushc  var_"+call0c);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "0D":
                                 //write to file "PUSHI"
                                String call0d;
                                call0d=content(3,d,data);
                                message.append("pushi  var_"+call0d);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "0E":
                                 //write to file "PUSHF"
                                   String call0e;
                                call0e=content(3,d,data);
                                message.append("pushf  var_"+call0e);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "0F":
                                //write to file "PUSHD"
                                 String call0f;
                                call0f=content(3,d,data);
                                message.append("pushd  var_"+call0f);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "10":
                                //write to file "PUSHS"
                                 String call10;
                                call10=content(3,d,data);
                                message.append("pushs  var_"+call10);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "11":
                                 //write to file "PUSHAC"
                                  String call11;
                                call11=content(3,d,data);
                                message.append("pushac  array_"+call11);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "12":
                                //write to file "PUSHAI"
                                   String call12;
                                call12=content(3,d,data);
                                message.append("pushai  array_"+call12);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "13":
                               //write to file "PUSHAF"
                                  String call13;
                                call13=content(3,d,data);
                                message.append("pushaf  array_"+call13);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "14":
                                //write to file "PUSHAD"
                                  String call14;
                                call14=content(3,d,data);
                                message.append("pushad array_"+call14);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "15":
                                //write to file "PUSHAS"
                                  String call15;
                                call15=content(3,d,data);
                                message.append("pushas array_"+call15);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "16":
                                //write to file "PUSHKC"
                                String call16;
                                call16=content(2,d,data);
                                message.append("pushkc var_"+call16);
                                d=d+2;
                                message.append("\n");
                                    break;
                                case "17":
                                 //write to file "PUSHKI"
                                 String call17;
                                call17=content(5,d,data);
                               
                                    long decimal5=Long.parseLong(call17,16);
                                    decimal5=~decimal5;
                                    decimal5++;
                                    decimal5=decimal5*-1;
                                    int dectemp=(int)decimal5;
                                       message.append("pushki "+dectemp);
                                       
                                    d=d+5;
                                    message.append("\n");
                               
                                
                                 
                                    break;
                                case "18":
                                 //write to file "PUSHKF"
                                String call18;
                                call18=content(5,d,data);
                                   message.append("pushkf var_"+call18);
                                d=d+5;
                                message.append("\n");
                                    break;
                                case "19":
                                  //write to file "PUSHKD"
                                   String call19;
                                call19=content(9,d,data);
                                   message.append("pushkd var_"+call19);
                                d=d+9;
                                message.append("\n");
                                    break;
                                case "1A":
                                  //write to file "PUSHKS"
                                   message.append("pushks ");
                                  String temp20=data.get(d+1);
                                  String temp30;
                                  d=d+2;
                                  int y = Integer.parseInt(temp20);
                                 int conttemp=0;
                                  int contemp2;
                                  char cc;
                                  while(conttemp<y)
                                  {
                                      contemp2=d+(conttemp);
                                      temp30=data.get(contemp2);
                                      int decimal = Integer.parseInt(temp30, 16);
                                      cc = (char)decimal;
                                      message.append(cc);
                                      conttemp=conttemp+1;
                                    }
                                    d=d+y;
                                    message.append("\n");
                                    break;
                                case "1B":
                                 //write to file "POPC"
                                  String call1b;
                                call1b=content(3,d,data);
                                   message.append("popc var_"+call1b);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "1C":
                                 //write to file "POPI"
                                 String call1c;
                                call1c=content(3,d,data);
                                   message.append("popi var_"+call1c);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "1D":
                               //write to file "POPF"
                                String call1d;
                                call1d=content(3,d,data);
                                   message.append("popf var_"+call1d);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "1E":
                                 //write to file "POPD"
                                     String call1e;
                                call1e=content(3,d,data);
                                   message.append("popd var_"+call1e);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "1F":
                                //write to file "pops"
                                   String call1f;
                                call1f=content(3,d,data);
                                   message.append("pops var_"+call1f);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "20":
                                //write to file "POPX"
                                  message.append("popx");
                                d=d+1;
                                message.append("\n");
                                    break;
                                case "21":
                               //write to file "POPAC"
                               String call21;
                                call21=content(3,d,data);
                                  message.append("popac address_"+call21);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "22":
                                //write to file "POPAI"
                                  String call22;
                                call22=content(3,d,data);
                                  message.append("popaa address_"+call22);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "23":
                               //write to file "POPAF"
                                 String call23;
                                call23=content(3,d,data);
                                  message.append("popaf address_"+call23);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "24":
                                //write to file "POPAD"
                                  String call24;
                                call24=content(3,d,data);
                                  message.append("popad address_"+call24);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "25":
                                //write to file "POPAS"
                                  String call25;
                                call25=content(3,d,data);
                                  message.append("popas address_"+call25);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "26":
                               //write to file "RDC"
                                  String call26;
                                call26=content(3,d,data);
                                  message.append("rdc var_"+call26);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "27":
                                //write to file "RDI"
                                String call27;
                                call27=content(3,d,data);
                                  message.append("rdi var_"+call27);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "28":
                                 //write to file "RDF"
                                    String call28;
                                call28=content(3,d,data);
                                  message.append("rdf var_"+call28);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "29":
                                //write to file "RDD"
                                   String call29;
                                call29=content(3,d,data);
                                  message.append("rdd var_"+call29);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "2A":
                                //write to file "RDS"
                                   String call2a;
                                call2a=content(3,d,data);
                                  message.append("rds var_"+call2a);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "2B":
                                 //write to file "RDAC"
                                     String call2b;
                                call2b=content(3,d,data);
                                  message.append("rdac array_"+call2b);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "2C":
                                 //write to file "RDAI"
                                  String call2c;
                                call2c=content(3,d,data);
                                  message.append("rdai array_"+call2c);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "2D":
                                 //write to file "RDAF"
                                     String call2d;
                                call2d=content(3,d,data);
                                  message.append("rdaf array_"+call2d);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "2E":
                                 //write to file "RDAD"
                                 String call2e;
                                call2e=content(3,d,data);
                                  message.append("rdad array_"+call2e);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "2F":
                                 //write to file "RDAS"
                                 String call2f;
                                call2f=content(3,d,data);
                                  message.append("rdas array_"+call2f);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "30":
                                //write to file "JMP"
                                String call30;
                                call30=content(3,d,data);
                                 message.append("jmp tag_"+call30);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "31":
                                 //write to file "JMPEQ"
                                String call31;
                                call31=content(3,d,data);
                                 message.append("jmpeq tag_"+call31);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "32":
                                  //write to file "JMPNE"
                                 String call32;
                                call32=content(3,d,data);
                                 message.append("jmpne tag_"+call32);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "33":
                                 //write to file "JMPGT"
                                   String call33;
                                call33=content(3,d,data);
                                 message.append("jmpgt tag_"+call33);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "34":
                                  //write to file "JMPGE"
                                   String call34;
                                call34=content(3,d,data);
                                 message.append("jmpge tag_"+call34);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "35":
                                  //write to file "JMPLT"
                                  String call35;
                                call35=content(3,d,data);
                                    message.append("jmplt tag_"+call35);
                                message.append("\n");
                                d=d+3;
                                    break;
                                case "36":
                                  //write to file "JMPLE"
                                   String call36;
                                call36=content(3,d,data);
                                   message.append("jmple tag_"+call36);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "37":
                                  //write to file "STX"
                                String call37;
                                call37=content(3,d,data);
                                 message.append("stx var_"+call37);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "38":
                                  //write to file "STKX"
                               message.append("STKX");
                               
                                String temp60;
                                int aa=0;
                                while(aa<4){
                                temp60=data.get(d+aa);
                                int decimal2 = Integer.parseInt(temp60, 16);
                                message.append(decimal2);
                                aa++;
                               }
                               d=d+5;
                                    break;
                                case "39":
                                 //write to file "INC"
                                 String call39;
                                call39=content(3,d,data);
                                   message.append("INC var_"+call39);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "3A":
                                 //write to file "DEC"
                                  String call3a;
                                call3a=content(3,d,data);
                                   message.append("DEC var_"+call3a);
                                d=d+3;
                                message.append("\n");
                                    break;
                                case "3B":
                                //write to file "ADD"
                                  message.append("add");
                                d=d+1;
                                message.append("\n");
                                    break;
                                case "3C":
                                //write to file "SUB"
                                message.append("SUB");
                                d=d+1;
                                message.append("\n");
                                break;
                                 case "3D":
                                //write to file "MUL"
                                message.append("MUL");
                                d=d+1;
                                message.append("\n");
                                break;
                                 case "3E":
                                //write to file "DIV"
                                message.append("DIV");
                                d=d+1;
                                message.append("\n");
                                break;
                                 case "3F":
                                //write to file "MOD"
                                message.append("MOD");
                                d=d+1;
                                message.append("\n");
                                break;
                                 case "40":
                                //write to file "CMP"
                                  message.append("cmp");
                                d=d+1;
                                message.append("\n");
                                    break;
                                default:
                                    break;
                            }
                        }
                  System.out.print(message);
                   try (PrintStream out = new PrintStream(new FileOutputStream(archivoagrabar))) {
                            out.print(message);
                            out.println();
                            out.flush();
                 }
                  System.out.println("Archivo CHOP convertido exitosamente");
                    System.out.println("Goodbye");
                   scanner.next();
    }
 
         byte[] readSmallBinaryFile(String aFileName) throws IOException {
        Path path = Paths.get(aFileName);
        return Files.readAllBytes(path);
      }
      
      void writeSmallBinaryFile(byte[] aBytes, String aFileName) throws IOException {
        Path path = Paths.get(aFileName);
        Files.write(path, aBytes); //creates, overwrites
      }
      private static List<String> getParts(String string, int partitionSize) {
        List<String> parts = new ArrayList<String>();
        int len = string.length();
        for (int i=0; i<len; i+=partitionSize)
        {
            parts.add(string.substring(i, Math.min(len, i + partitionSize)));
        }
        return parts;
    }
    public static String content(int bytes, int d,ArrayList<String> c)
    {
        
          int aa=0;
          int bb=bytes-1;
          int tempsuma=d+1;
          StringBuilder content = new StringBuilder();
                                while(aa<bb)
                                {
                                    content.append(c.get(tempsuma+aa));
                                    aa++;
                                }
                               
                                
        return content.toString();
    }
           
}