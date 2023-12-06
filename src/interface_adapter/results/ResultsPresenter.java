//package interface_adapter.results;
//import interface_adapter.ViewManagerModel;
//import interface_adapter.search.SearchState;
//import interface_adapter.search.SearchViewModel;
//import interface_adapter.specific.SpecificState;
//import interface_adapter.specific.SpecificViewModel;
//import use_case.results.ResultsOutputBoundary;
//import use_case.results.ResultsOutputData;
//import use_case.search.SearchOutputData;
//
//public class ResultsPresenter implements ResultsOutputBoundary{
//
//
//    private final ResultsViewModel resultsViewModel;
//    private final SpecificViewModel specificViewModel;
//    private ViewManagerModel viewManagerModel;
//
//
//    public ResultsPresenter(ResultsViewModel resultsViewModel,
//                           SpecificViewModel specificViewModel,
//                           ViewManagerModel viewManagerModel) {
//        this.resultsViewModel = resultsViewModel;
//        this.specificViewModel = specificViewModel;
//        this.viewManagerModel = viewManagerModel;
//    }
//
//    @Override
//    public void prepareSuccessView(ResultsOutputData response) {
//
//        SpecificState specificState = specificViewModel.getState();
//        specificState.setSpecific(response.getSpecific());
//        this.specificViewModel.setState(specificState);
//        this.specificViewModel.firePropertyChanged();
//
//        this.viewManagerModel.setActiveView(specificViewModel.getViewName());
//        this.viewManagerModel.firePropertyChanged();
//    }
//
//    @Override
//    public void prepareFailView(String error) {
//        ResultsState resultsState = resultsViewModel.getState();
//        resultsState.setResultsError(error);
//        this.resultsViewModel.setState(resultsState);
//        this.resultsViewModel.firePropertyChanged();
//    }
//
//}
