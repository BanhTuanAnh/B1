import java.util.Random;
import java.util.Scanner;

public class Game_tim_qua {

    static void inmang(String[][] map){
        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 4; j++) {
                System.out.print(map[j][i]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        // khoi tao mang
        Random random =  new Random();
        Scanner scanner=new Scanner(System.in);
        String[][] map= {
                {"*","*","*","*"},
                {"*","*","*","*"},
                {"*","*","*","*"},
                {"*","*","*","*"}
        };
        int temp;
        int xp,yp;
        int xe1,ye1;
        int xe2,ye2;
        int xg,yg;
        xp=random.nextInt(4);
        yp=random.nextInt(4);
        map[xp][yp]="P";
        do{
            yg=random.nextInt(4);
            xg=random.nextInt(4);
        }while(map[xg][yg]=="P");
        map[xg][yg]="G";
        do{
            xe1=random.nextInt(4);
            ye1=random.nextInt(4);
        }while(map[xe1][ye1]=="P" || map[xe1][ye1]=="G");
        map[xe1][ye1]="E";
        do{
            xe2=random.nextInt(4);
            ye2=random.nextInt(4);
        }while(map[xe2][ye2]=="P" || map[xe2][ye2]=="G" || map[xe2][ye2]=="E");
        map[xe2][ye2]="E";
       // choi
        while(true){
            //in mang va reset mang
            inmang(map);
            map[xp][yp]="*";
            map[xe1][ye1]="*";
            map[xe2][ye2]="*";
            if(xg==xe1 || yg == ye2)
                map[xg][yg]="G";
            // nguoi choi di
            System.out.println(" nhap ky tu : ");
            String key = scanner.next();
            switch (key){
                case "a":{
                    xp--;
                    break;
                }
                case "s":{

                    yp++;
                    break;
                }
                case "w":{
                    yp--;
                    break;
                }
                case "d":{
                    xp++;
                    break;
                }
                default:{
                    System.out.println("nhap lai");
                }
            }
            if(xp==map.length) xp=0;
            if(xp==-1) xp=map.length-1;
            if(yp==-1) yp=map.length-1;
            if(yp==map.length) yp=0;
            map[xp][yp]="P";
            //enemy di chuyen
            temp= xe1;
            do {
                xe1 = random.nextInt(4);
            }while(xe1==temp);
            temp=ye2;
            do{
                ye2 = random.nextInt(4);
            }while(ye2==temp);
            map[xe2][ye2]="E";
            map[xe1][ye1]="E";
            //kiem tra thang thua
            if((xp==xe1 && yp==ye1) || (yp == ye2 && xp == xe2 ) ){
                inmang(map);
                System.out.println("LOSER");
                break;
            }
            else if(xp==xg && yp == yg ){
                {
                    inmang(map);
                    System.out.println("Winner");
                    System.out.println(" You got the GOLD");
                    break;
                }
            }
        }
    }
}
