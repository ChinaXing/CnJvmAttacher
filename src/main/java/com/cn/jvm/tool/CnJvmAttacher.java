package com.cn.jvm.tool;

import com.sun.tools.attach.VirtualMachine;

/**
 * Created by ChinaXing on 14-10-10.
 */
public class CnJvmAttacher {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("usage : java -cp /path/to/jdk/lib/tools.jar:{thisJar}:. com.cn.jvm.tool.CnJvmAttacher attachPID agentJarFileAbsolutePath agentArgumentsString");
            System.out.println("eg: ");
            System.out.println("2022 /root/CnAgent.jar 'com.apple.concurrent.Dispatch::getInstance|System.out.println(\"ok\");'");
            return;
        }
        try {
            System.out.println("Agent Jar file  : " + args[1]);
            System.out.println("Agent Arguments : " + args[2]);

            Integer pid = Integer.parseInt(args[0]);
            String agentJar = args[1];
            VirtualMachine vm = VirtualMachine.attach(pid.toString());
            vm.loadAgent(agentJar, args[2]);
            System.out.println("Load agent ok");
        } catch (Exception e) {
            System.err.println("error:" + e.getMessage());
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
