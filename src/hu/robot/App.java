package hu.robot;

import hu.robot.controller.RobotService;
import hu.robot.model.service.*;

import java.util.Scanner;

public class App {

    private final RobotService robotService;
    private final Console console;
    private final FileWriter fileWriter;

    private App() {
        console = new Console(new Scanner(System.in));
        fileWriter = new FileWriter("ujprog.txt");
        DataApi dataApi = new DataApi(new FileReader(), new DataParser());
        robotService = new RobotService(dataApi.getData("program.txt"));
    }

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        System.out.print("2. feladat: Kérem az utasítássor sorszámát: ");
        int id = console.readInt();
        System.out.println(robotService.getReducibleStatus(id));
        System.out.println(robotService.getWayBackToOrigin(id));
        System.out.println(robotService.getFarthestStepDetails(id));
        System.out.println("3. feladat: A kis kapacitású akkumulátorral futtatható programok listája:");
        System.out.println(robotService.getLowCapacityBatteryPrograms());
        fileWriter.writeAll(robotService.getNewFormatPrograms());
        System.out.print("5. feladat: Adja meg az új formátumú programot: ");
        String commands = console.read();
        System.out.println(robotService.getOldFormatProgram(commands));
    }
}
