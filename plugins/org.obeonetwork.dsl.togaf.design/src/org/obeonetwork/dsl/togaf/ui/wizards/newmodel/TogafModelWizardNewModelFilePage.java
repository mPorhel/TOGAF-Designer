/*******************************************************************************
 * Copyright (c) 2011-2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.togaf.ui.wizards.newmodel;

import org.eclipse.jface.viewers.IStructuredSelection;

/**
 * The semantic model file creation page.
 *
 * @author ymortier
 */
public class TogafModelWizardNewModelFilePage extends AbstractTogafModelWizardNewFileCreationPage {

	/**
	 * Constructor.
	 *
	 * @param pageName the page name
	 * @param selection the selection
	 */
	public TogafModelWizardNewModelFilePage(String pageName, IStructuredSelection selection) {
		super(pageName, selection);
	}

	protected String getRequiredExtension() {
		return TogafModelWizard.MODEL_FILE_EXTENSION;
	}
}
