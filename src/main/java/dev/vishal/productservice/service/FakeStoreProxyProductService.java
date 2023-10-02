package dev.vishal.productservice.service;

import dev.vishal.productservice.dto.FakeStoreProductDTO;
import dev.vishal.productservice.dto.GenericProductDTO;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service("fakeProductService")
public class FakeStoreProxyProductService{

    private final RestTemplateBuilder restTemplateBuilder;
   // private  RestTemplate restTemplate;
    private final String specificProductRequestUrl = "https://fakestoreapi.com/products/{id}";
    private final String baseFakeStoreUrl = "https://fakestoreapi.com/products";

    @Lazy
    public FakeStoreProxyProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }


    @Bean
    public RestTemplateBuilder restTemplateBuilder() {
        return new RestTemplateBuilder();
    }

    //private static GenericProductDTO convertFakeStoreDtoToGenericDto(FakeStoreProductDTO fakeStoreProductDTO) {

            //GenericProductDTO genericProductDTO = new GenericProductDTO(fakeStoreProductDTO.id(), fakeStoreProductDTO.title(), fakeStoreProductDTO.price(), fakeStoreProductDTO.category(), fakeStoreProductDTO.description(), fakeStoreProductDTO.image());

          // return genericProductDTO;
   // }

   /* @Override
    public GenericProductDTO addProduct(AddProductRequest request) {
        return null;
    }

    @Override
    public GenericProductDTO getProductById(Long id) throws NotFoundException {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> response = restTemplate.getForEntity(specificProductRequestUrl, FakeStoreProductDTO.class, id);
        FakeStoreProductDTO product = response.getBody();

        if(product == null) {
            throw new NotFoundException(id + " not found");
        }
        GenericProductDTO  genericProduct = new GenericProductDTO(product.id(), product.title(), product.price(), product.category(), product.description(), product.image());

        return genericProduct;
    }

    @Override
    public GenericProductDTO deleteProduct(Long id) {

        RestTemplate restTemplate = restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDTO.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDTO>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDTO.class);
        ResponseEntity<FakeStoreProductDTO> response =  restTemplate.execute(specificProductRequestUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);

        return  convertFakeStoreDtoToGenericDto(response.getBody());

    }

    @Override
    public List<GenericProductDTO> getAllProducts() {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO[]> response = restTemplate.getForEntity(baseFakeStoreUrl, FakeStoreProductDTO[].class);

        List<GenericProductDTO> answer = new ArrayList<>();

        for(FakeStoreProductDTO product : Arrays.stream(response.getBody()).toList()) {
            answer.add(convertFakeStoreDtoToGenericDto(product));
        }

        return answer;
    }

    @Override
    public void updateProduct(GenericProductUpdateDTO product, Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        HttpEntity<GenericProductUpdateDTO> requestUpdate = new HttpEntity<>(product);
        System.out.println(requestUpdate.toString());
        restTemplate.exchange(baseFakeStoreUrl+"/"+id, HttpMethod.PUT, requestUpdate, Void.class);
    }*/
}
