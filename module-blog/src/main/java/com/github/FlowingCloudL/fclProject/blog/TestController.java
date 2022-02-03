package com.github.FlowingCloudL.fclProject.blog;

import com.github.FlowingCloudL.fclProject.infrastructure.utils.TestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestFeign testFeign;

    @GetMapping("/t/{msg}")
    public String testTest(@PathVariable("msg") String msg) {
        TestUtil.testUtil();
        return testFeign.testTest(msg);
    }
}
