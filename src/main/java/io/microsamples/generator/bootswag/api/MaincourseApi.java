/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.2.2).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package io.microsamples.generator.bootswag.api;

import io.microsamples.generator.bootswag.model.Maincourse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-23T09:40:01.114343-05:00[America/New_York]")

@Validated
@Api(value = "maincourse", description = "the maincourse API")
public interface MaincourseApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    @ApiOperation(value = "Available maincourse", nickname = "myMaincourse", notes = "All generated maincourse returned.", response = Maincourse.class, responseContainer = "List", tags={ "maincourse-controller", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Maincourse.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Invalid status value") })
    @GetMapping(value = "/maincourse",
        produces = { "application/json" })
    default ResponseEntity<List<Maincourse>> myMaincourse() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"size\" : 6, \"name\" : \"name\", \"id\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
