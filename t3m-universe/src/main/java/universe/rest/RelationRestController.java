package universe.rest;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import universe.model.JsonViews;
import universe.model.Relation;
import universe.model.Universe;
import universe.model.Character;
import universe.model.Element;
import universe.service.ElementService;
import universe.service.RelationService;
import universe.service.UniverseService;

@RestController
@RequestMapping("/api/relation")
public class RelationRestController {

    @Autowired
    private RelationService relationService;

    @GetMapping("/likeName/{name}")
    @JsonView(JsonViews.Common.class)
    public Set<String> relationLabelMatchingName( @PathVariable("name") String name ) {
        return relationService.likeName( name );
    }

    @PostMapping("")
    @JsonView( JsonViews.Common.class )
    @ResponseStatus( code = HttpStatus.CREATED )
    public Relation create( @Valid @RequestBody Relation relation, BindingResult br ) {
        Relation r = relationService.byId( relation.getId() );
        r.getNatures().addAll( relation.getNatures() );
        return relationService.save( r );

    }
}
