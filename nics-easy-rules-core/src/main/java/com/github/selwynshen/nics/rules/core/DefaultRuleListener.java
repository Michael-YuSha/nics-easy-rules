/**
 * The MIT License
 *
 *  Copyright (c) 2018, Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */
package com.github.selwynshen.nics.rules.core;

import com.github.selwynshen.nics.rules.api.Facts;
import com.github.selwynshen.nics.rules.api.Rule;
import com.github.selwynshen.nics.rules.api.RuleListener;

import com.github.selwynshen.nics.rules.api.Facts;
import com.github.selwynshen.nics.rules.api.Rule;
import com.github.selwynshen.nics.rules.api.RuleListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultRuleListener implements RuleListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultRuleListener.class);

    @Override
    public boolean beforeEvaluate(final Rule rule, final Facts facts) {
        return true;
    }

    @Override
    public void afterEvaluate(final Rule rule, final Facts facts, final boolean evaluationResult) {
        final String ruleName = rule.getName();
        if (evaluationResult) {
            LOGGER.info("Rule '{}' triggered", ruleName);
        } else {
            LOGGER.info("Rule '{}' has been evaluated to false, it has not been executed", ruleName);
        }
    }

    @Override
    public void beforeExecute(final Rule rule, final Facts facts) {

    }

    @Override
    public void onSuccess(final Rule rule, final Facts facts) {
        LOGGER.info("Rule '{}' performed successfully", rule.getName());
    }

    @Override
    public void onFailure(final Rule rule, final Facts facts, final Exception exception) {
        LOGGER.info("Rule '" + rule.getName() + "' performed with error", exception);
    }
}
