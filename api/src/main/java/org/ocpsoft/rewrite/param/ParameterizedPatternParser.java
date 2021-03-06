/*
 * Copyright 2013 <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ocpsoft.rewrite.param;

import java.util.Map;
import java.util.regex.Pattern;

import org.ocpsoft.rewrite.context.EvaluationContext;
import org.ocpsoft.rewrite.event.Rewrite;

/**
 * 
 * A {@link Parameterized} regular expression {@link Pattern}.
 * 
 * @author <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 * 
 */
public interface ParameterizedPatternParser extends ParameterizedPattern
{
   /**
    * Return the {@link ParameterizedPatternBuilder} corresponding to the pattern with which this
    * {@link ParameterizedPatternParser} was constructed.
    */
   ParameterizedPatternBuilder getBuilder();

   /**
    * Return true if this expression matches the given {@link String}.
    */
   boolean matches(String name);

   /**
    * Return true if this expression matches the given {@link String}.
    */
   boolean matches(Rewrite rewrite, EvaluationContext context, String value);

   /**
    * Parses the given string if it matches this expression. Returns a {@link org.ocpsoft.rewrite.param.Parameter}-value
    * map of parsed values. This method does not apply any {@link Transposition} instances that may be registered.
    */
   Map<Parameter<?>, String> parse(String value);

   /**
    * Parses the given string if it matches this expression. Returns a {@link org.ocpsoft.rewrite.param.Parameter}-value
    * map of parsed values.
    */
   Map<Parameter<?>, String> parse(Rewrite rewrite, EvaluationContext context, String value);

}
