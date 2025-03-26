package org.palladiosimulator.simulizar.failurescenario.di;

import org.palladiosimulator.simulizar.di.core.scopes.RuntimeExtensionScope;
import org.palladiosimulator.simulizar.interpreter.InterpreterDefaultContext;

import dagger.Binds;
import dagger.Module;

@Module
public interface FailurescenarioExtensionModule {
	@Binds
    @RuntimeExtensionScope
	InterpreterDefaultContext bindContext(InterpreterDefaultContext impl);
}
