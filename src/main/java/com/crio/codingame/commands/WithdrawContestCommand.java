package com.crio.codingame.commands;

import java.util.List;
import javax.management.openmbean.InvalidOpenTypeException;
import com.crio.codingame.dtos.UserRegistrationDto;
import com.crio.codingame.exceptions.ContestNotFoundException;
import com.crio.codingame.exceptions.UserNotFoundException;
import com.crio.codingame.services.IUserService;

public class WithdrawContestCommand implements ICommand {

    private final IUserService userService;

    public WithdrawContestCommand(IUserService userService) {
        this.userService = userService;
    }

    // TODO: CRIO_TASK_MODULE_CONTROLLER
    // Execute withdrawContest method of IUserService and print the result.
    // Also Handle Exceptions and print the error messsages if any.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["WITHDRAW_CONTEST","3","Joey"]
    // Hint - Use Parameterized Exceptions in the Service class to match with the Unit Tests Output.

    @Override
    public void execute(List<String> tokens) {
        String contestId = tokens.get(1);
        String userName = tokens.get(2);
        try {
            UserRegistrationDto dto = userService.withdrawContest(contestId, userName);
            System.out.println(dto);
        } catch (ContestNotFoundException e) {
            System.out.println(
                    "Cannot Withdraw Contest. Contest for given id:" + contestId + " not found!");
        } catch (UserNotFoundException e) {
            System.out.println(
                    "Cannot Withdraw Contest. User for given name:" + userName + " not found!");
        } catch (InvalidOpenTypeException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    // catch(Exception e) at the end provides a safety net to catch any unanticipated exceptions,
    // which helps to ensure the code runs smoothly, and test cases pass without any issues.
}

