# async-profiler-playground

- https://github.com/jvm-profiling-tools/async-profiler
- http://corpaul.github.io/flamegraphdiff/
- https://www.youtube.com/watch?v=ugRrFdda_JQ
- IntelliJ Support: https://www.jetbrains.com/help/idea/cpu-profiler.html

```
mvn gatling:test -Dgatling.simulationClass=pbouda.asyncprofiler.gatling.Generator
mvn gatling:test -Dgatling.simulationClass=pbouda.asyncprofiler.gatling.GeneratorLock

profiler.sh -d 30 -e context-switches -f profile.svg <pid>
```

```
profiler.sh <pid> list
Basic events:
  cpu
  alloc
  lock
  wall
  itimer
Perf events:
  page-faults
  context-switches
  cycles
  instructions
  cache-references
  cache-misses
  branches
  branch-misses
  bus-cycles
  L1-dcache-load-misses
  LLC-load-misses
  dTLB-load-misses
  mem:breakpoint
  trace:tracepoint
```

```
profiler.sh                        
Usage: $ASYNC_PROFILER_HOME/profiler.sh [action] [options] <pid>
Actions:
  start             start profiling and return immediately
  stop              stop profiling
  status            print profiling status
  list              list profiling events supported by the target JVM
  collect           collect profile for the specified period of time
                    and then stop (default action)
Options:
  -e event          profiling event: cpu|alloc|lock|cache-misses etc.
  -d duration       run profiling for <duration> seconds
  -f filename       dump output to <filename>
  -i interval       sampling interval in nanoseconds
  -j jstackdepth    maximum Java stack depth
  -b bufsize        frame buffer size
  -t                profile different threads separately
  -s                simple class names instead of FQN
  -a                annotate Java method names
  -o fmt[,fmt...]   output format: summary|traces|flat|collapsed|svg|tree|jfr
  -v, --version     display version string

  --title string    SVG title
  --width px        SVG width
  --height px       SVG frame height
  --minwidth px     skip frames smaller than px
  --reverse         generate stack-reversed FlameGraph / Call tree

  --all-kernel      only include kernel-mode events
  --all-user        only include user-mode events

<pid> is a numeric process ID of the target JVM
      or 'jps' keyword to find running JVM automatically

Example: $ASYNC_PROFILER_HOME/profiler.sh -d 30 -f profile.svg 3456
         $ASYNC_PROFILER_HOME/profiler.sh start -i 999000 jps
         $ASYNC_PROFILER_HOME/profiler.sh stop -o summary,flat jps
```