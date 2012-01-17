package de.krkm.util.owlparser;

import de.krkm.util.owlparser.generated.OWLFunctionalSyntaxParser;
import de.krkm.util.owlparser.generated.ParseException;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyLoaderConfiguration;
import org.semanticweb.owlapi.model.OWLOntologyManager;

import java.io.StringReader;

/**
 * A parser for OWL2 Functional syntax which supports parsing of single
 */
public class OWLFunctionalAxiomParser {
    /**
     * Parses the given line which has to be an axiom in OWL2 Functional syntax
     * @param line OWL2 Functional axiom
     * @return axiom represented by line
     * @throws ParserException on an error while parsing the line
     */
    public static OWLAxiom parseAxiom(String line) throws ParserException {
        OWLOntologyManager m = OWLManager.createOWLOntologyManager();
        OWLFunctionalSyntaxParser parser = new OWLFunctionalSyntaxParser(new StringReader(line));
        OWLOntologyLoaderConfiguration c = new OWLOntologyLoaderConfiguration();
        try {
            parser.setUp(m.createOntology(), c);
            return parser.Axiom();
        }
        catch (OWLOntologyCreationException e) {
            throw new ParserException(e);
        }
        catch (ParseException e) {
            throw new ParserException(e);
        }
    }
}
