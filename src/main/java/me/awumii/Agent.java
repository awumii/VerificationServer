package me.awumii;

import java.lang.instrument.Instrumentation;

// In PrismLauncher, edit instance, switch to Version tab, on the right panel select Add Agent.
public class Agent {
    public static void premain(String agentArgs, Instrumentation inst) {
        VerificationServer.main(null);
    }
}
