# False Sharing 

- https://www.javaspecialists.eu/archive/Issue249.html
- https://mechanical-sympathy.blogspot.com/2011/07/false-sharing.html

We need to export a protected module to our compiler

```
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.8.0</version>
    <configuration>
        <source>11</source>
        <target>11</target>

        <compilerArgs>
            <arg>--add-exports</arg>
            <arg>java.base/jdk.internal.m.annotation=ALL-UNNAMED</arg>
        </compilerArgs>
    </configuration>
</plugin>
```

```
--add-exports java.base/jdk.internal.vm.annotation=ALL-UNNAMED -XX:-RestrictContended
```