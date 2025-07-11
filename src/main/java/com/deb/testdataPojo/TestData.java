package com.deb.testdataPojo;

import com.deb.converters.StringToBooleanConverter;
import io.github.sskorol.data.Column;
import io.github.sskorol.data.Sheet;
import io.github.sskorol.data.Source;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Source(path = "testdata.xlsx")
@Sheet(name = "runData")
public class TestData {

    @Column(name = "testcasename")
    public String testcaseName;

    @Column(name = "username")
    public String username;

    @Column(name = "password")
    public String password;

    @Column(name = "assertion value")
    public String assertionValue;

    @Column(name = "execute", converter = StringToBooleanConverter.class)
    public Boolean isExecute;
}
