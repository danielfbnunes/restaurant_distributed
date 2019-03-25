/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import states.WaiterStates;

/**
 *
 * @author dn
 */
public interface WaiterInterface {

    /**
     * Used to set the waiter's state.
     *
     * @param s receives Waiter State, from {@link Entities.States.WaiterStates
     * }.
     */
    public void setWaiterState(WaiterStates s);
}
