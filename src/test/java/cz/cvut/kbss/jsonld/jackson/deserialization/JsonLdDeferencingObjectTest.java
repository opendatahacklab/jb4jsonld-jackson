/**
 * 
 */
package cz.cvut.kbss.jsonld.jackson.deserialization;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import cz.cvut.kbss.jsonld.jackson.JsonLdModule;

/**
 * @author cristianolongo
 *
 */
public class JsonLdDeferencingObjectTest {

    private ObjectMapper objectMapper;
    private JsonLdModule jsonLdModule;

    @BeforeEach
    void setUp() {
        this.objectMapper = new ObjectMapper();
        this.jsonLdModule = new JsonLdModule();
        objectMapper.registerModule(jsonLdModule);
    }

	@Test
	public void testTwoChildWithTwoDifferentProperties() throws IOException {
		final ParentWithTwoChildren p = new ParentWithTwoChildren();
		
		final Child ca = new Child();
		ca.setIri("http://example.org/a");
		p.setHasChildA(ca);

		final Child cb = new Child();
		cb.setIri("http://example.org/b");
		p.setHasChildB(cb);

		final Child f = new Child();
		f.setIri("http://example.org/f");
		ca.setHasFriend(f);
		cb.setHasFriend(f);

		final byte[] parentSerialized = objectMapper.writeValueAsBytes(p);
		final ParentWithTwoChildren parentDeserialized = objectMapper.readValue(parentSerialized,
				ParentWithTwoChildren.class);
		assertEquals(ca.getIri(), parentDeserialized.getHasChildA().getIri());
		assertEquals(cb.getIri(), parentDeserialized.getHasChildB().getIri());
		assertEquals(f.getIri(), parentDeserialized.getHasChildA().getHasFriend().getIri());
		assertSame(parentDeserialized.getHasChildA().getHasFriend(), parentDeserialized.getHasChildB().getHasFriend());
	}
}
