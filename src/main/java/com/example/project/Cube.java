import java.util.Scanner;
import java.util.ArrayList;


//Looks fairly omcplete to me, could be easier to use but thats fine.

public class cubes {

    String [][] cube = {{
        "r","r","r",
        "r","r","r",
        "r","r","r"
        }, 
        {
        "b","b","b",
        "b","b","b",
        "b","b","b"
        },
        {
        "o","o","o",
        "o","o","o",
        "o","o","o"
        }, 
        {
        "g","g","g",
        "g","g","g",
        "g","g","g"
        }, 
        {
        "y","y","y",
        "y","y","y",
        "y","y","y"
        }, 
        {
        "w","w","w",
        "w","w","w",
        "w","w","w"
        }
    };

    class edgedFace{
        public int current_face;
        int []edge1 = new int[4];
        int []edge2 = new int[4];
        int []edge3 = new int[4];
        int []edge4 = new int[4];

        public edgedFace(int face){
            current_face = face;

            switch(face) {
                case 0:
                    edge1[0] = 1;
                    edge1[1] = 2;
                    edge1[2] = 5;
                    edge1[3] = 8;

                    edge2[0] = 4;
                    edge2[1] = 2;
                    edge2[2] = 5;
                    edge2[3] = 8;

                    edge3[0] = 3;
                    edge3[1] = 0;
                    edge3[2] = 3;
                    edge3[3] = 6;

                    edge4[0] = 5;
                    edge4[1] = 2;
                    edge4[2] = 5;
                    edge4[3] = 8;
                    break;
  
                case 1:
                    edge1[0] = 2;
                    edge1[1] = 2;
                    edge1[2] = 5;
                    edge1[3] = 8;
                    
                    edge2[0] = 4;
                    edge2[1] = 2;
                    edge2[2] = 5;
                    edge2[3] = 8;

                    edge3[0] = 0;
                    edge3[1] = 0;
                    edge3[2] = 3;
                    edge3[3] = 6;

                    edge4[0] = 5;
                    edge4[1] = 2;
                    edge4[2] = 5;
                    edge4[3] = 8;
                    break;

                case 2:
                    edge1[0] = 3;
                    edge1[1] = 2;
                    edge1[2] = 5;
                    edge1[3] = 8;
                    
                    edge2[0] = 4;
                    edge2[1] = 2;
                    edge2[2] = 5;
                    edge2[3] = 8;

                    edge3[0] = 1;
                    edge3[1] = 0;
                    edge3[2] = 3;
                    edge3[3] = 6;

                    edge4[0] = 5;
                    edge4[1] = 2;
                    edge4[2] = 5;
                    edge4[3] = 8;
                    break;

                case 3:
                    edge1[0] = 0;
                    edge1[1] = 2;
                    edge1[2] = 5;
                    edge1[3] = 8;

                    edge2[0] = 4;
                    edge2[1] = 2;
                    edge2[2] = 5;
                    edge2[3] = 8;

                    edge3[0] = 2;
                    edge3[1] = 0;
                    edge3[2] = 3;
                    edge3[3] = 6;

                    edge4[0] = 5;
                    edge4[1] = 2;
                    edge4[2] = 5;
                    edge4[3] = 8;
                    break;
    
                case 4:
                    edge1[0] = 1;
                    edge1[1] = 2;
                    edge1[2] = 5;
                    edge1[3] = 8;
                    
                    edge2[0] = 2;
                    edge2[1] = 2;
                    edge2[2] = 5;
                    edge2[3] = 8;

                    edge3[0] = 3;
                    edge3[1] = 0;
                    edge3[2] = 3;
                    edge3[3] = 6;

                    edge4[0] = 0;
                    edge4[1] = 2;
                    edge4[2] = 5;
                    edge4[3] = 8;
                    break;

                case 5:
                    edge1[0] = 1;
                    edge1[1] = 2;
                    edge1[2] = 5;
                    edge1[3] = 8;
                    
                    edge2[0] = 0;
                    edge2[1] = 2;
                    edge2[2] = 5;
                    edge2[3] = 8;

                    edge3[0] = 3;
                    edge3[1] = 0;
                    edge3[2] = 3;
                    edge3[3] = 6;

                    edge4[0] = 2;
                    edge4[1] = 2;
                    edge4[2] = 5;
                    edge4[3] = 8;
                    break;
            }
        }
    }

    public void turnFace(int index, String direction) {
        edgedFace eFace = new edgedFace(index);

        String [][] copy = new String[6][9];

        for (int i = 0; i < 6; i++){
            for (int j =0; j <9; j++){
                copy [i][j] = cube [i][j];
            }
        }

        switch (direction){
            case "c":
                cube [eFace.current_face][0] = copy[eFace.current_face][6];
                cube [eFace.current_face][1] = copy[eFace.current_face][3];
                cube [eFace.current_face][2] = copy[eFace.current_face][0];
                cube [eFace.current_face][3] = copy[eFace.current_face][7];
                cube [eFace.current_face][5] = copy[eFace.current_face][1];
                cube [eFace.current_face][6] = copy[eFace.current_face][8];
                cube [eFace.current_face][7] = copy[eFace.current_face][5];
                cube [eFace.current_face][8] = copy[eFace.current_face][2];

                //edge 1 changed
                cube[eFace.edge1[0]][eFace.edge1[1]] = copy[eFace.edge4[0]][eFace.edge4[1]];
                cube[eFace.edge1[0]][eFace.edge1[2]] = copy[eFace.edge4[0]][eFace.edge4[2]];
                cube[eFace.edge1[0]][eFace.edge1[3]] = copy[eFace.edge4[0]][eFace.edge4[3]];

                //edge 2 changed 
                cube[eFace.edge2[0]][eFace.edge2[1]] = copy[eFace.edge1[0]][eFace.edge1[1]];
                cube[eFace.edge2[0]][eFace.edge2[2]] = copy[eFace.edge1[0]][eFace.edge1[2]];
                cube[eFace.edge2[0]][eFace.edge2[3]] = copy[eFace.edge1[0]][eFace.edge1[3]];
                
                //edge 3 changed
                cube[eFace.edge3[0]][eFace.edge3[1]] = copy[eFace.edge2[0]][eFace.edge2[1]];
                cube[eFace.edge3[0]][eFace.edge3[2]] = copy[eFace.edge2[0]][eFace.edge2[2]];
                cube[eFace.edge3[0]][eFace.edge3[3]] = copy[eFace.edge2[0]][eFace.edge2[3]];

                //edge 4 changed
                cube[eFace.edge4[0]][eFace.edge4[1]] = copy[eFace.edge3[0]][eFace.edge3[1]];
                cube[eFace.edge4[0]][eFace.edge4[2]] = copy[eFace.edge3[0]][eFace.edge3[2]];
                cube[eFace.edge4[0]][eFace.edge4[3]] = copy[eFace.edge3[0]][eFace.edge3[3]];
                break;

            case "cc":
                cube [eFace.current_face][0] = copy[eFace.current_face][2];
                cube [eFace.current_face][1] = copy[eFace.current_face][5];
                cube [eFace.current_face][2] = copy[eFace.current_face][8];
                cube [eFace.current_face][3] = copy[eFace.current_face][1];
                cube [eFace.current_face][5] = copy[eFace.current_face][7];
                cube [eFace.current_face][6] = copy[eFace.current_face][0];
                cube [eFace.current_face][7] = copy[eFace.current_face][3];
                cube [eFace.current_face][8] = copy[eFace.current_face][6];

                //edge 1 changed
                cube[eFace.edge1[0]][eFace.edge1[1]] = copy[eFace.edge2[0]][eFace.edge2[1]];
                cube[eFace.edge1[0]][eFace.edge1[2]] = copy[eFace.edge2[0]][eFace.edge2[2]];
                cube[eFace.edge1[0]][eFace.edge1[3]] = copy[eFace.edge2[0]][eFace.edge2[3]];

                //edge 2 changed
                cube[eFace.edge2[0]][eFace.edge2[1]] = copy[eFace.edge3[0]][eFace.edge3[1]];
                cube[eFace.edge2[0]][eFace.edge2[2]] = copy[eFace.edge3[0]][eFace.edge3[2]];
                cube[eFace.edge2[0]][eFace.edge2[3]] = copy[eFace.edge3[0]][eFace.edge3[3]];

                //edge 3 changed
                cube[eFace.edge3[0]][eFace.edge3[1]] = copy[eFace.edge4[0]][eFace.edge4[1]];
                cube[eFace.edge3[0]][eFace.edge3[2]] = copy[eFace.edge4[0]][eFace.edge4[2]];
                cube[eFace.edge3[0]][eFace.edge3[3]] = copy[eFace.edge4[0]][eFace.edge4[3]];

                //edge 4 changed
                cube[eFace.edge4[0]][eFace.edge4[1]] = copy[eFace.edge1[0]][eFace.edge1[1]];
                cube[eFace.edge4[0]][eFace.edge4[2]] = copy[eFace.edge1[0]][eFace.edge1[2]];
                cube[eFace.edge4[0]][eFace.edge4[3]] = copy[eFace.edge1[0]][eFace.edge1[3]];
                break;
        }

    }

    public void showCube() {
        int ind = 0;
        for(int x=0; x<6; x++){
            for (int y=0; y <3; y++){
                for (int z=0; z<3; z++){
                    System.out.print(cube[x][ind++]);
                }
                System.out.println();
            }
            ind = 0;
            System.out.println();
        }
    }

    public String reverseString (String x) {

        char ch;
        String nstr = "";

        for (int i = 0; i < x.length(); i++) {
            ch = x.charAt(i);
            nstr = ch + nstr;
        }

        return nstr;

    }


    public static void main(String[]args){

        Scanner in = new Scanner (System.in);

        cubes Rubiks = new cubes();

        boolean proceed = true;

        while(proceed){
            
            String input = in.nextLine();
            String solve = "";

            switch (input) {

                //Yellow C
                case "u":
                    Rubiks.turnFace(4, "c");
                    Rubiks.showCube();
                    solve += "u ";
                    break;
                //Yellow Cc
                case "u'":
                    Rubiks.turnFace(4, "cc");
                    Rubiks.showCube();
                    solve += "u' ";
                    break;
                //White C
                case "d":
                    Rubiks.turnFace(5, "c");
                    Rubiks.showCube();
                    solve += "d ";
                    break;

                //White Cc
                case "d'":
                    Rubiks.turnFace(5, "cc");
                    Rubiks.showCube();
                    solve += "d' ";
                    break;

                //Red C
                case "r":
                    Rubiks.turnFace(0, "c");
                    Rubiks.showCube();
                    solve += "r ";
                    break;

                //Red Cc
                case "r'":
                    Rubiks.turnFace(0, "cc");
                    Rubiks.showCube();
                    solve += "r' ";
                    break;

                //Orange C
                case "l":
                    Rubiks.turnFace(2, "c");
                    Rubiks.showCube();
                    solve += "l ";
                    break;

                //Orange Cc
                case "l'":
                    Rubiks.turnFace(2, "cc");
                    Rubiks.showCube();
                    solve += "l' ";
                    break;

                //Blue C
                case "f":
                    Rubiks.turnFace(1, "c");
                    Rubiks.showCube();
                    solve += "f ";
                    break;

                //Blue Cc
                case "f'":
                    Rubiks.turnFace(1, "cc");
                    Rubiks.showCube();
                    solve += "f' ";
                    break;

                //Green C
                case "b":
                    Rubiks.turnFace(3, "c");
                    Rubiks.showCube();
                    solve += "b ";
                    break;

                //Green CC
                case "b'":
                    Rubiks.turnFace(3, "cc");
                    Rubiks.showCube();
                    solve += "b' ";
                    break;

                //Quit
                case "q":
                    proceed = false;
                    break;
            }
        }
    }
}
