/*
 *  Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package io.samjs.plugins.checkpanic.analyzertasks;

import io.ballerina.compiler.syntax.tree.CheckExpressionNode;
import io.ballerina.compiler.syntax.tree.NodeLocation;
import io.ballerina.compiler.syntax.tree.SyntaxKind;
import io.ballerina.compiler.syntax.tree.Token;
import io.ballerina.projects.plugins.AnalysisTask;
import io.ballerina.projects.plugins.SyntaxNodeAnalysisContext;
import io.ballerina.tools.diagnostics.Diagnostic;
import io.ballerina.tools.diagnostics.DiagnosticFactory;
import io.ballerina.tools.diagnostics.DiagnosticInfo;
import io.ballerina.tools.diagnostics.DiagnosticSeverity;

/**
 * An {@code AnalysisTask} that is triggered for each usage of 'checkpanic' construct in a Ballerina package.
 *
 * @since 1.0.0
 */
public class CheckingExpressionAnalysisTask implements AnalysisTask<SyntaxNodeAnalysisContext> {

    private final DiagnosticInfo checkPanicDiagnosticDesc;

    public CheckingExpressionAnalysisTask() {
        checkPanicDiagnosticDesc = new DiagnosticInfo("CHECKPANIC-101",
                "'checkpanic' usage detected, consider 'check' instead", DiagnosticSeverity.WARNING);
    }

    @Override
    public void perform(SyntaxNodeAnalysisContext analysisContext) {
        CheckExpressionNode checkingExprNode = (CheckExpressionNode) analysisContext.node();
        Token checkingKeyword = checkingExprNode.checkKeyword();
        if (checkingKeyword.kind() != SyntaxKind.CHECKPANIC_KEYWORD) {
            return;
        }

        NodeLocation diagnosticLocation = checkingExprNode.location();
        Diagnostic checkPanicDiagnostic = DiagnosticFactory.createDiagnostic(checkPanicDiagnosticDesc,
                diagnosticLocation);
        analysisContext.reportDiagnostic(checkPanicDiagnostic);
    }
}
