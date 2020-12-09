package diana.springframework.msscbeerservice.web.controller;

import diana.springframework.msscbeerservice.web.model.BeerDto;
import diana.springframework.msscbeerservice.services.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    private final BeerService beerService;

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable UUID beerId) {
       // return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
        return new ResponseEntity<>(beerService.getById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDto> saveNewBeer(@RequestBody @Validated BeerDto beerDto) {
       return new ResponseEntity<>(beerService.saveNewBeer(beerDto), HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<BeerDto> updateBeerById(@PathVariable UUID beerId, @RequestBody @Validated BeerDto beerDto) {
        return new ResponseEntity<>(beerService.updateBeer(beerId, beerDto), HttpStatus.NO_CONTENT);
    }
}
