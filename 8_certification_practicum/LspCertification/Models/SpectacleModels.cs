namespace LspCertification.Models;

public class SpectacleModels
{
    
}


public class SpectacleCreateRequest
{
    public string SpectacleCode { get; set; } = string.Empty;
    public string SpectacleType { get; set; } = string.Empty;
    public string SpectacleBrand { get; set; } = string.Empty;
    public decimal Price { get; set; }
    public int Stock { get; set; }
    public Guid DistributorId { get; set; }
}

public class SpectacleUpdateRequest
{
    public string SpectacleCode { get; set; } = string.Empty;
    public string SpectacleType { get; set; } = string.Empty;
    public string SpectacleBrand { get; set; } = string.Empty;
    public decimal Price { get; set; }
    public int Stock { get; set; }
    public Guid DistributorId { get; set; }
    
}
public class SpectacleResource
{
    public Guid SpectacleId { get; set; }
    public string SpectacleType { get; set; } = string.Empty;
    public string SpectacleCode { get; set; } = string.Empty;
    public string SpectacleBrand { get; set; } = string.Empty;
    public decimal Price { get; set; }
    public int Stock { get; set; }
    public Guid DistributorId { get; set; }
    public string Distributor { get; set; } = string.Empty;
}