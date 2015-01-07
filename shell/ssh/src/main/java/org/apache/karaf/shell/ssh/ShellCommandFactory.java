/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.karaf.shell.ssh;

import org.apache.felix.service.command.CommandProcessor;
import org.apache.sshd.server.Command;
import org.apache.sshd.server.CommandFactory;

public class ShellCommandFactory implements CommandFactory {

    private CommandProcessor commandProcessor;
    private boolean consoleLogger = false;
    private String consoleLoggerName;
    private String consoleLoggerOutLevel;
    private String consoleLoggerErrLevel;

    public void setCommandProcessor(CommandProcessor commandProcessor) {
        this.commandProcessor = commandProcessor;
    }

    public void setConsoleLogger(boolean consoleLogger) {
        this.consoleLogger = consoleLogger;
    }

    public void setConsoleLoggerName(String consoleLoggerName) {
        this.consoleLoggerName = consoleLoggerName;
    }

    public void setConsoleLoggerOutLevel(String consoleLoggerOutLevel) {
        this.consoleLoggerOutLevel = consoleLoggerOutLevel;
    }

    public void setConsoleLoggerErrLevel(String consoleLoggerErrLevel) {
        this.consoleLoggerErrLevel = consoleLoggerErrLevel;
    }

    public Command createCommand(String command) {
        return new ShellCommand(commandProcessor, command, consoleLogger, consoleLoggerName, consoleLoggerOutLevel, consoleLoggerErrLevel);
    }

}
