using System;
using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace LspCertification.Migrations
{
    /// <inheritdoc />
    public partial class InitialMigration : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "Distributors",
                columns: table => new
                {
                    DistributorId = table.Column<Guid>(type: "TEXT", nullable: false),
                    DistributorCode = table.Column<string>(type: "TEXT", maxLength: 6, nullable: false),
                    DistributorName = table.Column<string>(type: "TEXT", maxLength: 128, nullable: false),
                    Address = table.Column<string>(type: "TEXT", maxLength: 255, nullable: false),
                    EmailAddress = table.Column<string>(type: "TEXT", maxLength: 128, nullable: false),
                    PhoneNumber = table.Column<string>(type: "TEXT", maxLength: 15, nullable: false),
                    ContactPerson = table.Column<string>(type: "TEXT", maxLength: 128, nullable: false),
                    IsDeleted = table.Column<bool>(type: "INTEGER", nullable: false),
                    CreatedAt = table.Column<DateTime>(type: "TEXT", nullable: false),
                    LastModifiedAt = table.Column<DateTime>(type: "TEXT", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Distributors", x => x.DistributorId);
                });

            migrationBuilder.CreateTable(
                name: "Spectacles",
                columns: table => new
                {
                    SpectacleId = table.Column<Guid>(type: "TEXT", nullable: false),
                    SpectacleCode = table.Column<string>(type: "TEXT", maxLength: 6, nullable: false),
                    SpectacleType = table.Column<string>(type: "TEXT", maxLength: 128, nullable: false),
                    SpectacleBrand = table.Column<string>(type: "TEXT", maxLength: 128, nullable: false),
                    Price = table.Column<decimal>(type: "TEXT", precision: 18, scale: 2, nullable: false),
                    Stock = table.Column<int>(type: "INTEGER", nullable: false),
                    DistributorId = table.Column<Guid>(type: "TEXT", nullable: false),
                    IsDeleted = table.Column<bool>(type: "INTEGER", nullable: false),
                    CreatedAt = table.Column<DateTime>(type: "TEXT", nullable: false),
                    LastModifiedAt = table.Column<DateTime>(type: "TEXT", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Spectacles", x => x.SpectacleId);
                    table.ForeignKey(
                        name: "FK_Spectacles_Distributors_DistributorId",
                        column: x => x.DistributorId,
                        principalTable: "Distributors",
                        principalColumn: "DistributorId",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateIndex(
                name: "IX_Spectacles_DistributorId",
                table: "Spectacles",
                column: "DistributorId");
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Spectacles");

            migrationBuilder.DropTable(
                name: "Distributors");
        }
    }
}
