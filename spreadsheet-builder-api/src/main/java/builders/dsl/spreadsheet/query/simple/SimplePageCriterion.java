package builders.dsl.spreadsheet.query.simple;

import builders.dsl.spreadsheet.api.Keywords;
import builders.dsl.spreadsheet.api.Page;
import builders.dsl.spreadsheet.api.Sheet;
import builders.dsl.spreadsheet.query.api.PageCriterion;
import builders.dsl.spreadsheet.query.api.Predicate;

public class SimplePageCriterion implements PageCriterion {

    private final SimpleWorkbookCriterion workbookCriterion;

    SimplePageCriterion(SimpleWorkbookCriterion workbookCriterion) {
        this.workbookCriterion = workbookCriterion;
    }

    @Override
    public SimplePageCriterion orientation(final Keywords.Orientation orientation) {
        workbookCriterion.addCondition(new Predicate<Sheet>() {
            @Override
            public boolean test(Sheet o) {
                return orientation.equals(o.getPage().getOrientation());
            }
        });
        return this;
    }

    @Override
    public SimplePageCriterion paper(final Keywords.Paper paper) {
        workbookCriterion.addCondition(new Predicate<Sheet>() {
            @Override
            public boolean test(Sheet o) {
                return paper.equals(o.getPage().getPaper());
            }
        });
        return this;
    }

    @Override
    public PageCriterion having(final Predicate<Page> pagePredicate) {
        workbookCriterion.addCondition(new Predicate<Sheet>() {
            @Override
            public boolean test(Sheet o) {
                return pagePredicate.test(o.getPage());
            }
        });
        return this;
    }
}
