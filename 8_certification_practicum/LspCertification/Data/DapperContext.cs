using System.Data;
using Dapper;
using Microsoft.Data.Sqlite;

namespace LspCertification.Data;

public class DapperContext
{
    protected readonly IConfiguration Configuration;
    
    public DapperContext(IConfiguration configuration)
    {
        Configuration = configuration;
    }
    
    public IDbConnection CreateConnection()
    {
        SqlMapper.AddTypeHandler(new DateTimeOffsetHandler());
        SqlMapper.AddTypeHandler(new GuidHandler());
        SqlMapper.AddTypeHandler(new TimeSpanHandler());
        return new SqliteConnection(Configuration.GetConnectionString("DefaultConnection"));
    }
}

abstract class SqliteTypeHandler<T> : SqlMapper.TypeHandler<T>
{
    // Parameters are converted by Microsoft.Data.Sqlite
    public override void SetValue(IDbDataParameter parameter, T? value)
        => parameter.Value = value;
}

class DateTimeOffsetHandler : SqliteTypeHandler<DateTimeOffset>
{
    public override DateTimeOffset Parse(object value)
        => DateTimeOffset.Parse((string)value);
}

class GuidHandler : SqliteTypeHandler<Guid>
{
    public override Guid Parse(object value)
        => Guid.Parse((string)value);
}

class TimeSpanHandler : SqliteTypeHandler<TimeSpan>
{
    public override TimeSpan Parse(object value)
        => TimeSpan.Parse((string)value);
}