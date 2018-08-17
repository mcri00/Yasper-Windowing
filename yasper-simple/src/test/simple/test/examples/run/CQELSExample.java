package simple.test.examples.run;

import it.polimi.yasper.core.quering.execution.ContinuousQueryExecution;
import it.polimi.yasper.core.quering.querying.ContinuousQuery;
import it.polimi.yasper.core.quering.rspql.window.WindowNode;
import it.polimi.yasper.core.stream.rdf.RegisteredRDFStream;
import it.polimi.yasper.core.utils.EngineConfiguration;
import it.polimi.yasper.core.utils.QueryConfiguration;
import it.polimi.yasper.core.utils.RDFUtils;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.rdf.api.Graph;
import simple.querying.formatter.ContinuousQueryImpl;
import simple.querying.formatter.InstResponseSysOutFormatter;
import simple.test.examples.CQELSmpl;
import simple.test.examples.Elem;
import simple.test.examples.RDFStreamDecl;
import simple.windowing.WindowNodeImpl;

import java.net.URL;
import java.time.Duration;

/**
 * Created by Riccardo on 03/08/16.
 */
public class CQELSExample {

    static CQELSmpl sr;

    public static void main(String[] args) throws ConfigurationException {

        URL resource = CQELSExample.class.getResource("/default.properties");
        QueryConfiguration config = new QueryConfiguration(resource.getPath());
        EngineConfiguration ec = EngineConfiguration.loadConfig("/default.properties");

        sr = new CQELSmpl(0, ec);

        //STREAM DECLARATION
        RDFStreamDecl stream = new RDFStreamDecl("stream1");

        RegisteredRDFStream painter_reg = sr.register(stream);

        //_____

        ContinuousQuery q = new ContinuousQueryImpl("q1");

        WindowNode wn = new WindowNodeImpl(RDFUtils.createIRI("w1"), Duration.ofSeconds(2), 0);

        q.addNamedWindow("stream1", wn);

        ContinuousQueryExecution cqe = sr.register(q, config);

        cqe.addFormatter(new InstResponseSysOutFormatter("TTL", true));

        //RUNTIME DATA

        Graph graph = RDFUtils.getInstance().createGraph();
        graph.add(RDFUtils.getInstance().createTriple(RDFUtils.getInstance().createIRI("S1"), RDFUtils.getInstance().createIRI("p"), RDFUtils.getInstance().createIRI("O1")));

        painter_reg.put(new Elem(1000, graph));

        graph = RDFUtils.getInstance().createGraph();
        graph.add(RDFUtils.getInstance().createTriple(RDFUtils.getInstance().createIRI("S2"), RDFUtils.getInstance().createIRI("p"), RDFUtils.getInstance().createIRI("O2")));

        painter_reg.put(new Elem(1999, graph));

        graph = RDFUtils.getInstance().createGraph();
        graph.add(RDFUtils.getInstance().createTriple(RDFUtils.getInstance().createIRI("S3"), RDFUtils.getInstance().createIRI("p"), RDFUtils.getInstance().createIRI("O3")));

        painter_reg.put(new Elem(2001, graph));
        graph = RDFUtils.getInstance().createGraph();

        graph.add(RDFUtils.getInstance().createTriple(RDFUtils.getInstance().createIRI("S4"), RDFUtils.getInstance().createIRI("p"), RDFUtils.getInstance().createIRI("O4")));

        painter_reg.put(new Elem(3000, graph));

        graph = RDFUtils.getInstance().createGraph();
        graph.add(RDFUtils.getInstance().createTriple(RDFUtils.getInstance().createIRI("S5"), RDFUtils.getInstance().createIRI("p"), RDFUtils.getInstance().createIRI("O5")));

        painter_reg.put(new Elem(5000, graph));

        graph = RDFUtils.getInstance().createGraph();
        graph.add(RDFUtils.getInstance().createTriple(RDFUtils.getInstance().createIRI("S6"), RDFUtils.getInstance().createIRI("p"), RDFUtils.getInstance().createIRI("O6")));

        painter_reg.put(new Elem(5000, graph));
        painter_reg.put(new Elem(6000, graph));

        graph = RDFUtils.getInstance().createGraph();
        graph.add(RDFUtils.getInstance().createTriple(RDFUtils.getInstance().createIRI("S7"), RDFUtils.getInstance().createIRI("p"), RDFUtils.getInstance().createIRI("O7")));

        painter_reg.put(new Elem(7000, graph));
        //stream.put(new it.polimi.deib.ssp.windowing.RDFStreamDecl.Elem(3000, graph));

    }

}
