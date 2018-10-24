package com.liferay.training.gradebook.service.permission.impl;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.AuthException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.training.gradebook.service.permission.AssignmentPermissionChecker;

/**
 * Gradebook permission checker implementation.
 * 
 * @author liferay
 *
 */
@Component(
		immediate = true,
		property = {
			"model.class.name=com.liferay.training.gradebook.model.Assignment"
		},
		service = AssignmentPermissionChecker.class 
	)
public class AssignmentPermissionCheckerImpl implements AssignmentPermissionChecker {

	@Override
	public void check(
		PermissionChecker permissionChecker, long groupId, long assignmentId,
		String actionId)
			throws AuthException {

		if (!contains(permissionChecker, groupId, assignmentId, actionId)) {
			throw new AuthException();
		}
	}
	
	@Override
	public boolean contains(
		PermissionChecker permissionChecker, long groupId, long assignmentId,
		String actionId) {

		return (permissionChecker.hasPermission(
			groupId, RESOURCE_NAME, assignmentId, actionId));
	}

	@Override
	public void checkTopLevel(
		PermissionChecker permissionChecker, long groupId, String actionId)
			throws AuthException {

		if (!containsTopLevel(permissionChecker, groupId, actionId)) {
			throw new AuthException();
		}
	}

	@Override
	public boolean containsTopLevel(
		PermissionChecker permissionChecker, long groupId, String actionId) {
		return (permissionChecker.hasPermission(
			groupId, TOP_LEVEL_RESOURCE, groupId, actionId));
	}
	
	@Override
	public void checkBaseModel(PermissionChecker permissionChecker, long groupId, long primaryKey, String actionId)
			throws PortalException {
			check(permissionChecker, groupId, primaryKey, actionId);
	}
}

