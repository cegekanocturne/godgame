package com.cegeka.nocturne.godgame;

import java.io.IOException;
import java.util.Scanner;

public class StartWorld {
    public static void main(String[] args) {

        World world = null;

        String command = "x";
        Scanner terminalInput = new Scanner(System.in);

        while (!"q".equals(command)) {
            command = terminalInput.nextLine();
            if ("s".equals(command.toLowerCase()) || "start".equals(command.toLowerCase())) {
                if (world == null)  {
                    world = new World(5);
                    world.getTime().start();
                    System.out.println(world);
                }
            }
            if ("p".equals(command.toLowerCase()) || "pause".equals(command.toLowerCase())) {
                if (world == null)
                    System.out.println("Create world first!");
                else
                    world.getTime().pause();
            }
            if ("r".equals(command.toLowerCase()) || "resume".equals(command.toLowerCase())) {
                if (world == null)
                    System.out.println("Create world first!");

                //resume
            }

        }

    }


}
