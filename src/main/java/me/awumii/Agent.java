package me.awumii;

import java.io.IOException;
import java.lang.instrument.Instrumentation;

// In PrismLauncher, edit instance, switch to Version tab, on the right panel select Add Agent.
public class Agent {
    public static void premain(String agentArgs, Instrumentation inst) throws IOException {
        var minecraftDir = System.getenv("INST_MC_DIR");
        Runtime.getRuntime().exec("pkexec java -jar " + minecraftDir + "/VerificationServer.jar");
    }
}
