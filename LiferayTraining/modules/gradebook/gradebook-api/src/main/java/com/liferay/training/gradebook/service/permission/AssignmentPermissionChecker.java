
package com.liferay.training.gradebook.service.permission;

import com.liferay.portal.kernel.security.auth.AuthException;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.training.gradebook.model.Assignment;

/**
 * Gradebook assignments permission checker interface.
 * 
 * @author liferay
 *
 */
public interface AssignmentPermissionChecker
	extends BaseModelPermissionChecker {

	public static final String ADD_ASSIGNMENT = "ADD_ASSIGNMENT";
	
	public static final String RESOURCE_NAME = Assignment.class.getName();
	
	public static final String TOP_LEVEL_RESOURCE =
		Assignment.class.getName().substring(
			0, Assignment.class.getName().lastIndexOf("."));

	public void check(
		PermissionChecker permissionChecker, long groupId, long assignmentId,
		String actionId)
		throws AuthException;

	public void checkTopLevel(
		PermissionChecker permissionChecker, long groupId, String actionId)
		throws AuthException;

	public boolean contains(
		PermissionChecker permissionChecker, long groupId, long assignmentId,
		String actionId);

	public boolean containsTopLevel(
		PermissionChecker permissionChecker, long groupId, String actionId);
}
