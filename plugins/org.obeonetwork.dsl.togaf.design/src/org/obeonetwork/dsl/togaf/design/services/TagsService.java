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
package org.obeonetwork.dsl.togaf.design.services;

import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.togaf.design.tags.SemanticResourceSelectorHandler;

/**
 * Utility class for the Tags metamodel.
 * 
 * @author SDrapeau
 * 
 */
public class TagsService {

	/**
	 * Get the root element of the semantic model.
	 * 
	 * @param e
	 *            not used.
	 * @return
	 */
	public EObject getRootElement(EObject e) {
		if (SemanticResourceSelectorHandler.getSemanticResourceSelector() != null) {
			return SemanticResourceSelectorHandler
					.getSemanticResourceSelector().getRootElement();
		}
		return null;
	}

	/**
	 * Get the root element of the Tags model.
	 * 
	 * @param e
	 *            not used.
	 * @return
	 */
	public EObject getTagsRoot(EObject e) {
		if (SemanticResourceSelectorHandler.getSemanticResourceSelector() != null) {
			return SemanticResourceSelectorHandler
					.getSemanticResourceSelector().getTagsRoot();
		}
		return null;
	}

}
