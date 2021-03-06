﻿// <auto-generated />
using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure;
using Microsoft.EntityFrameworkCore.Metadata;
using Microsoft.EntityFrameworkCore.Storage.ValueConversion;
using SStorage.Data;

namespace SStorage.Migrations
{
    [DbContext(typeof(SStorageDbContext))]
    partial class SStorageDbContextModelSnapshot : ModelSnapshot
    {
        protected override void BuildModel(ModelBuilder modelBuilder)
        {
#pragma warning disable 612, 618
            modelBuilder
                .HasAnnotation("ProductVersion", "2.1.0-rtm-30799")
                .HasAnnotation("Relational:MaxIdentifierLength", 128)
                .HasAnnotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn);

            modelBuilder.Entity("SStorage.Models.Environment", b =>
                {
                    b.Property<long>("Id")
                        .ValueGeneratedOnAdd()
                        .HasAnnotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn);

                    b.Property<string>("Name")
                        .IsRequired()
                        .HasMaxLength(40);

                    b.HasKey("Id");

                    b.ToTable("Environments");
                });

            modelBuilder.Entity("SStorage.Models.Movement", b =>
                {
                    b.Property<long>("Id")
                        .ValueGeneratedOnAdd()
                        .HasAnnotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn);

                    b.Property<DateTime>("DateTime");

                    b.Property<long>("DestinyEnvironmentId");

                    b.Property<long>("OriginEnvironmentId");

                    b.Property<long>("PatrimonyItemId");

                    b.Property<long>("UserId");

                    b.HasKey("Id");

                    b.HasIndex("DestinyEnvironmentId");

                    b.HasIndex("OriginEnvironmentId");

                    b.HasIndex("PatrimonyItemId");

                    b.HasIndex("UserId");

                    b.ToTable("Movements");
                });

            modelBuilder.Entity("SStorage.Models.Patrimony", b =>
                {
                    b.Property<long>("Id")
                        .ValueGeneratedOnAdd()
                        .HasAnnotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn);

                    b.Property<DateTime>("DateTime");

                    b.Property<string>("Name")
                        .IsRequired()
                        .HasMaxLength(40);

                    b.Property<long>("PatrimonyCategoryId");

                    b.Property<long>("UserId");

                    b.HasKey("Id");

                    b.HasIndex("PatrimonyCategoryId");

                    b.HasIndex("UserId");

                    b.ToTable("Patrimonies");
                });

            modelBuilder.Entity("SStorage.Models.PatrimonyCategory", b =>
                {
                    b.Property<long>("Id")
                        .ValueGeneratedOnAdd()
                        .HasAnnotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn);

                    b.Property<string>("Name")
                        .IsRequired()
                        .HasMaxLength(30);

                    b.HasKey("Id");

                    b.ToTable("PatrimonyCategories");
                });

            modelBuilder.Entity("SStorage.Models.PatrimonyItem", b =>
                {
                    b.Property<long>("Id");

                    b.Property<long>("EnvironmentId");

                    b.Property<DateTime>("LastMovement");

                    b.Property<long>("PatrimonyId");

                    b.Property<int>("State");

                    b.Property<long>("UserId");

                    b.HasKey("Id");

                    b.HasIndex("EnvironmentId");

                    b.HasIndex("PatrimonyId");

                    b.HasIndex("UserId");

                    b.ToTable("PatrimonyItems");
                });

            modelBuilder.Entity("SStorage.Models.User", b =>
                {
                    b.Property<long>("Id")
                        .ValueGeneratedOnAdd()
                        .HasAnnotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn);

                    b.Property<string>("Email")
                        .IsRequired();

                    b.Property<string>("LastName")
                        .IsRequired()
                        .HasMaxLength(40);

                    b.Property<string>("Name")
                        .IsRequired()
                        .HasMaxLength(20);

                    b.Property<string>("PasswordDatabase")
                        .IsRequired()
                        .HasMaxLength(128);

                    b.Property<int>("UserType");

                    b.HasKey("Id");

                    b.ToTable("Users");
                });

            modelBuilder.Entity("SStorage.Models.Movement", b =>
                {
                    b.HasOne("SStorage.Models.Environment", "DestinyEnvironment")
                        .WithMany()
                        .HasForeignKey("DestinyEnvironmentId")
                        .OnDelete(DeleteBehavior.Restrict);

                    b.HasOne("SStorage.Models.Environment", "OriginEnvironment")
                        .WithMany()
                        .HasForeignKey("OriginEnvironmentId")
                        .OnDelete(DeleteBehavior.Restrict);

                    b.HasOne("SStorage.Models.PatrimonyItem", "PatrimonyItem")
                        .WithMany()
                        .HasForeignKey("PatrimonyItemId")
                        .OnDelete(DeleteBehavior.Restrict);

                    b.HasOne("SStorage.Models.User", "User")
                        .WithMany()
                        .HasForeignKey("UserId")
                        .OnDelete(DeleteBehavior.Restrict);
                });

            modelBuilder.Entity("SStorage.Models.Patrimony", b =>
                {
                    b.HasOne("SStorage.Models.PatrimonyCategory", "PatrimonyCategory")
                        .WithMany()
                        .HasForeignKey("PatrimonyCategoryId")
                        .OnDelete(DeleteBehavior.Restrict);

                    b.HasOne("SStorage.Models.User", "User")
                        .WithMany()
                        .HasForeignKey("UserId")
                        .OnDelete(DeleteBehavior.Restrict);
                });

            modelBuilder.Entity("SStorage.Models.PatrimonyItem", b =>
                {
                    b.HasOne("SStorage.Models.Environment", "Environment")
                        .WithMany()
                        .HasForeignKey("EnvironmentId")
                        .OnDelete(DeleteBehavior.Restrict);

                    b.HasOne("SStorage.Models.Patrimony", "Patrimony")
                        .WithMany()
                        .HasForeignKey("PatrimonyId")
                        .OnDelete(DeleteBehavior.Restrict);

                    b.HasOne("SStorage.Models.User", "User")
                        .WithMany()
                        .HasForeignKey("UserId")
                        .OnDelete(DeleteBehavior.Restrict);
                });
#pragma warning restore 612, 618
        }
    }
}
