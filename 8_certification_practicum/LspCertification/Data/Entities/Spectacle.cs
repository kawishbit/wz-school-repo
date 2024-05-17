using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using Microsoft.EntityFrameworkCore;

namespace LspCertification.Data.Entities;

[Table("Spectacles")]
public class Spectacle : BaseEntity
{
    
    [Key] public Guid SpectacleId { get; set; } = Guid.NewGuid();
    [Required, MaxLength(6)] public string SpectacleCode { get; set; } = string.Empty;
    [Required, MaxLength(128)] public string SpectacleType { get; set; } = string.Empty;
    [MaxLength(128)] public string SpectacleBrand { get; set; } = string.Empty;
    [Precision(18, 2)] public decimal Price { get; set; }
    public int Stock { get; set; }
    [ForeignKey(nameof(Distributor))] public Guid DistributorId { get; set; }
    public virtual Distributor Distributor { get; set; } = new();
    
    
    public void SetId(Guid id)
    {
        SpectacleId = id;
    }
}