/*******************************************************************************
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.togaf.ui.actions;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;
import org.obeonetwork.dsl.togaf.ui.Activator;
import org.obeonetwork.dsl.togaf.ui.editors.WebBrowserEditor;
import org.obeonetwork.dsl.togaf.ui.editors.WebBrowserInput;
import org.obeonetwork.dsl.togaf.ui.util.properties.TogafProperties;

/**
 * @author sdrapeau
 * 
 */
public class OpenBrowserAction extends Action implements IWorkbenchWindowActionDelegate {

    /**
     * 
     */
    public OpenBrowserAction() {
	setText(Messages.OpenBrowserAction_0);
	setToolTipText(Messages.OpenBrowserAction_1);
	setImageDescriptor(Activator.getImageDescriptor("browser.gif")); //$NON-NLS-1$
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
     */
    public final void run(final IAction action) {
	openEditor();
    }

    /**
     * 
     */
    private void openEditor() {
	try {
	    IProgressService service = PlatformUI.getWorkbench().getProgressService();
	    service.busyCursorWhile(new IRunnableWithProgress() {
		public void run(final IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
		    Display.getDefault().asyncExec(new Runnable() {
			public void run() {
			    try {
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				WebBrowserInput input = new WebBrowserInput("http://" + TogafProperties.WEB_SERVER + ":" + TogafProperties.WEB_PORT); //$NON-NLS-1$ //$NON-NLS-2$
				page.openEditor(input, WebBrowserEditor.ID);

			    } catch (PartInitException e) {
				MessageDialog.openError(Activator.getActiveWorkbenchShell(), Messages.OpenBrowserAction_5, e.getLocalizedMessage());
			    }
			}
		    });

		}
	    });
	} catch (Exception e) {
	    MessageDialog.openError(Activator.getActiveWorkbenchShell(), Messages.OpenBrowserAction_6, Messages.OpenBrowserAction_7);
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.action.Action#run()
     */
    public final void run() {
	run(this);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.IWorkbenchWindowActionDelegate#init(org.eclipse.ui.IWorkbenchWindow)
     */
    public void init(final IWorkbenchWindow window) {
	// Nada.
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.IWorkbenchWindowActionDelegate#dispose()
     */
    public void dispose() {
	// Nada.
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction, org.eclipse.jface.viewers.ISelection)
     */
    public void selectionChanged(final IAction action, final ISelection selection) {
	// Nada.
    }

}
