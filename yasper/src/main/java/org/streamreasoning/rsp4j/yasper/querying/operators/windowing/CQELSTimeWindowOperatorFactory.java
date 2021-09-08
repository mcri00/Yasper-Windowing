package org.streamreasoning.rsp4j.yasper.querying.operators.windowing;

import org.apache.commons.rdf.api.Graph;
import org.streamreasoning.rsp4j.api.enums.ReportGrain;
import org.streamreasoning.rsp4j.api.enums.Tick;
import org.streamreasoning.rsp4j.api.operators.s2r.StreamToRelationOperatorFactory;
import org.streamreasoning.rsp4j.api.operators.s2r.execution.assigner.StreamToRelationOp;
import org.streamreasoning.rsp4j.api.secret.content.ContentFactory;
import org.streamreasoning.rsp4j.api.secret.report.Report;
import org.streamreasoning.rsp4j.api.secret.time.Time;

public class CQELSTimeWindowOperatorFactory implements StreamToRelationOperatorFactory<Graph, Graph> {

    //    private long a;
//    private long t0;
    private final Time time;
    private final Tick tick;
    private final Report report;
    private final ReportGrain grain;
    private final ContentFactory<Graph, Graph> cf;
//    private ContinuousQueryExecution<Graph, Graph, Triple> context;

    public CQELSTimeWindowOperatorFactory(Time time, Tick tick, Report report, ReportGrain grain, ContentFactory<Graph, Graph> cf) {
//        this.a = a;
//        this.t0 = t0;
        this.time = time;
        this.tick = tick;
        this.report = report;
        this.grain = grain;
//        this.context = context;
        this.cf = cf;
    }

    //TODO consider a Params interface
    @Override
    public StreamToRelationOp<Graph, Graph> build(long a, long b, long t0) {
        return new CQELSStreamToRelationOp<>(null, a, time, tick, report, grain, cf);
    }


}
