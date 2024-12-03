/**
 * Name: Andre Arsyan Jordie
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/28/2024
 * File Name: Main.java
 * Description: This class is responsible for the application entry point.
 */

package edu.bu.met.cs665;

import edu.bu.met.cs665.mbta.simulations.GreenLine;
import edu.bu.met.cs665.utils.ThreadManager;

/**
 * This is the Main class.
 */
public class Main {

  /**
   * Main entry point.
   */
  public static void main(String[] args) {
    // Create the Thread Pool
    ThreadManager threadManager = new ThreadManager();

    // Create the GreenLine simulation.
    GreenLine greenLine = new GreenLine(threadManager);

    // Start the simulation in a thread.
    threadManager.addTask(greenLine::start);
  }
}
