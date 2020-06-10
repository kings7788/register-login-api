package tw.com.bryant.config.document;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.AlternateTypePropertyBuilder;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.sql.Timestamp;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class DocketConfiguration {

    @Bean
    public Docket apiAttr() {
        return new Docket(DocumentationType.SWAGGER_2)
//                .host("10.1.1.55:45088")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(or(regex("/v1/.*")))
                .build()
                // .directModelSubstitute(Page.class, String.class)
                .useDefaultResponseMessages(false)
//                .tags(
//                        new Tag("ClockOut 及會員資訊", "Detail 頁"),
//                        new Tag("ClockIn", "Home 頁"),
//                        new Tag("賽桌資訊", "賽桌 id 與攝影機 RTSP"),
//                        new Tag("臉部辨識", "臉部辨識結果"),
//                        new Tag("Customer 資訊管理", "透過 cid 取得詳細的會員資訊"),
//                        new Tag("會員卡管理", "透過 cda 取得詳細的會員資訊"),
//                        new Tag("[Unused] Log on", "Dealer log on"))
                .directModelSubstitute(Timestamp.class, Long.class)
                .forCodeGeneration(true);

    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Genting System API Documentation")
                .description("For POC")
                .contact(new Contact("delphi", "", "delphi.kuo@cloud-interactive.com"))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0.0")
                .build();
    }
    private AlternateTypePropertyBuilder property(Class<?> type, String name) {
        return new AlternateTypePropertyBuilder()
                .withName(name)
                .withType(type)
                .withCanRead(true)
                .withCanWrite(true);
    }

}
