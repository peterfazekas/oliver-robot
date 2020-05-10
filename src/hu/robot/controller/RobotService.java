package hu.robot.controller;

import hu.robot.model.domain.Program;
import hu.robot.model.service.ProgramHelper;

import java.util.List;
import java.util.stream.Collectors;

public class RobotService {

    private final List<Program> programs;

    public RobotService(List<Program> programs) {
        this.programs = programs;
    }

    public String getReducibleStatus(int id) {
        return getProgramById(id).isReducible() ? "egyszerűsíthető" : "nem egyszerűsíthető";
    }

    public String getWayBackToOrigin(int id) {
        return getProgramById(id).getWayBackToOrigin();
    }

    public String getFarthestStepDetails(int id) {
        return getProgramById(id).getFarthestStepDetails();
    }

    private Program getProgramById(int id) {
        return programs.stream()
                .filter(i -> i.getId() == id)
                .findFirst()
                .get();
    }

    public String getLowCapacityBatteryPrograms() {
        return programs.stream()
                .filter(Program::isLowCapacityBattery)
                .map(program -> program.getId() + " " + program.getBatteryDemand())
                .collect(Collectors.joining("\r\n"));
    }

    public List<String> getNewFormatPrograms() {
        return programs.stream()
                .map(Program::getCommands)
                .map(ProgramHelper::convertToNewFormat)
                .collect(Collectors.toList());
    }

    public String getOldFormatProgram(String commands) {
        return ProgramHelper.convertToOldFormat(commands);
    }
}
