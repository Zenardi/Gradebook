package com.liferay.training.userindexerpostprocessor;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.IndexerPostProcessor;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.search.filter.BooleanFilter;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"indexer.class.name=com.liferay.portal.kernel.model.User",
	},
	service = IndexerPostProcessor.class
)
public class UserIndexerPostProcessor implements IndexerPostProcessor {

	@Override
	public void postProcessContextBooleanFilter(
			BooleanFilter booleanFilter, SearchContext searchContext)
		throws Exception {

		System.out.println("postProcessContextBooleanFilter");
	}

	@Override
	public void postProcessContextQuery(
			BooleanQuery contextQuery, SearchContext searchContext)
		throws Exception {

		System.out.println("postProcessContextQuery");
	}

	@Override
	public void postProcessDocument(Document document, Object obj)
		throws Exception {

		System.out.println("postProcessDocument");

		User user = (User)obj;
		
		int male = 0;
		
		if (user.isMale()) {
			male = 1;
		}
		
		document.addNumber("male", male);
		
	}

	@Override
	public void postProcessFullQuery(
			BooleanQuery fullQuery, SearchContext searchContext)
		throws Exception {

		System.out.println("postProcessFullQuery");
	}

	@Override
	public void postProcessSearchQuery(
			BooleanQuery searchQuery, BooleanFilter booleanFilter,
			SearchContext searchContext)
		throws Exception {

		System.out.println("postProcessSearchQuery-1");
	}

	@Override
	public void postProcessSearchQuery(
			BooleanQuery searchQuery, SearchContext searchContext)
		throws Exception {

		System.out.println("postProcessSearchQuery-2");

		String keywords = searchContext.getKeywords();
		
		if (keywords == null) {
			return;
		}

		searchQuery.addTerm("userId", searchContext.getKeywords());

		if (keywords.contains("boys") || keywords.contains("guys") ||
			keywords.contains("men") || keywords.contains("dudes")) {
			
			searchQuery.addTerm("male", 1);
		}
	}

	@Override
	public void postProcessSummary(
		Summary summary, Document document, Locale locale, String snippet) {

		System.out.println("postProcessSummary");
	}

}
