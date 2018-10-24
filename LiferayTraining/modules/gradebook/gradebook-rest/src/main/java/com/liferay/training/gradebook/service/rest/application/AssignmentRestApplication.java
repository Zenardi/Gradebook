
package com.liferay.training.gradebook.service.rest.application;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyService;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.training.gradebook.model.Assignment;
import com.liferay.training.gradebook.service.AssignmentLocalService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true, 
	property = {
		"liferay.auth.verifier=false", 
	    "liferay.oauth2=false",
		"osgi.jaxrs.application.base=" + "/gradebook-rest",
	    "osgi.jaxrs.name=Gradebook.Rest"
	}, 
	service = Application.class)
public class AssignmentRestApplication extends Application {

	public Set<Object> getSingletons() {

		return Collections.<Object> singleton(this);
	}

	@GET
	@Path("/assignments")
	@Produces({
		MediaType.APPLICATION_JSON
	})
	public String getAssignments() {

		Company company;
		List<Assignment> assignments = new ArrayList<Assignment>();

		//try {
			//company = _companyService.getCompanyById(
			//	PortalUtil.getDefaultCompanyId());
			List<Group> groups =
				_groupLocalService.getGroups(PortalUtil.getDefaultCompanyId(), 0, true);
			for (Group group : groups) {
				assignments.addAll(
					_assignmentLocalService.getAssignmentsByGroupId(
						group.getGroupId()));
			}
			return JSONFactoryUtil.serialize(assignments);

		//}
		//catch (PortalException e) {
		//	return "[{}]";
		//}
	}

	@GET
	@Path("/assignment/{assignmentid}")
	@Produces({
		MediaType.APPLICATION_JSON
	})
	public String getAssignments(@PathParam("assignmentid") long assignmentId) {

		try {
			return JSONFactoryUtil.serialize(
				_assignmentLocalService.getAssignment(assignmentId));
		}
		catch (Exception e) {
			return "{}";
		}
	}

	@Reference
	private AssignmentLocalService _assignmentLocalService;

	@Reference
	private CompanyService _companyService;

	@Reference
	private GroupLocalService _groupLocalService;
}
