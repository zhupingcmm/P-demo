package com.mf.reflect.bytebuddy;

import net.bytebuddy.agent.builder.AgentBuilder;

import java.lang.instrument.Instrumentation;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class Agent {
    public static void premain(String args, Instrumentation inst) {

        System.out.println("loading agent");

        Listener listener = new Listener();
        new AgentBuilder.Default().type(named("com.mf.app.Greeting"))
                .transform(new Transformer())
                .with(AgentBuilder.RedefinitionStrategy.RETRANSFORMATION)
//                .with(listener)
                .installOn(inst);

        System.out.println("agent has bead loaded");

    }

    public static void agentmain(String args, Instrumentation inst) {
    }
}
