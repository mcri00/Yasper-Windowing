package ssp.utils;

import it.polimi.yasper.core.rspql.execution.ContinuousQueryExecution;
import it.polimi.yasper.core.rspql.formatter.QueryResponseFormatter;
import it.polimi.yasper.core.rspql.querying.ContinuousQuery;
import it.polimi.yasper.core.rspql.response.InstantaneousResponse;
import it.polimi.yasper.core.rspql.sds.SDS;
import it.polimi.yasper.core.spe.content.Content;
import it.polimi.yasper.core.spe.windowing.assigner.WindowAssigner;

import java.util.Observable;
import java.util.Observer;

public class    StreamViewImpl extends Observable implements ContinuousQueryExecution, Observer {

    private Content content;

    @Override
    public void update(Observable o, Object arg) {
        WindowAssigner window_assigner = (WindowAssigner) o;
        this.content = window_assigner.getContent((Long) arg);
        setChanged();
        notifyObservers(arg);
    }

    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
    }


    @Override
    public InstantaneousResponse eval(long ts) {
        return null;
    }

    @Override
    public ContinuousQuery getContinuousQuery() {
        return null;
    }

    @Override
    public String getQueryID() {
        return null;
    }

    @Override
    public SDS getSDS() {
        return null;
    }

    @Override
    public void addFormatter(QueryResponseFormatter o) {

    }

    @Override
    public void deleteFormatter(QueryResponseFormatter o) {

    }
}
